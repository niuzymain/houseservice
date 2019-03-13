package com.house.web.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.house.entity.Reserve;
import com.house.entity.User;
import com.house.service.user.UserReserveService;
import com.house.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserReserveService userReserveService;

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> registerUser(HttpServletRequest request) {
        Map<String, Object> modelmap = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        String userstr = request.getParameter("register");
        try {
            User user = objectMapper.readValue(userstr, User.class);
            int result = userService.addUser(user);
            if (result > 0) {
                modelmap.put("success", true);
            } else {
                modelmap.put("success", false);
            }
            return modelmap;
        } catch (Exception e) {
            e.printStackTrace();
            modelmap.put("success", false);
            modelmap.put("errormsg", e.getMessage());
            return modelmap;
        }
    }

    @RequestMapping(value = "/userlogout", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> userLogout(HttpServletRequest request) {
        Map<String, Object> modelmap = new HashMap<>();
        request.getSession().setAttribute("useraccount", null);
        modelmap.put("success", true);
        return modelmap;
    }

    @RequestMapping(value = "/getuserinfo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUserInfo(HttpServletRequest request) {
        Map<String, Object> modelmap = new HashMap<>();
        User currentuser = (User) request.getSession().getAttribute("useraccount");
        currentuser.setAccountname(null);
        currentuser.setPassword(null);
        try {
            User user = userService.selectSingleUser(currentuser);
            modelmap.put("result", user);
            modelmap.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            modelmap.put("errormsg", e.getMessage());
            modelmap.put("success", false);
        }
        return modelmap;
    }

    @RequestMapping(value = "/operateuserinfo", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> operateUserInfo(HttpServletRequest request) {
        Map<String, Object> modelmap = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        String userstr = request.getParameter("userstr");
        User currentuser = (User) request.getSession().getAttribute("useraccount");
        try {
            User user = objectMapper.readValue(userstr,User.class);
            user.setUserid(currentuser.getUserid());
           int result = userService.editUser(user);
           if(result > 0){
               modelmap.put("success", true);
           }
        } catch (Exception e) {
            e.printStackTrace();
            modelmap.put("errormsg", e.getMessage());
            modelmap.put("success", false);
        }
        return modelmap;
    }

    @RequestMapping(value = "/getuserreserve", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUserReserve(HttpServletRequest request) {
        Map<String, Object> modelmap = new HashMap<>();
        User user = (User) request.getSession().getAttribute("useraccount");
        int status = Integer.parseInt(request.getParameter("status"));
        Reserve reserve = new Reserve();
        reserve.setUser(user);
        reserve.setEnablestatus(status);
        List<Reserve> reserveList = userReserveService.selectReservelist(reserve);
        modelmap.put("success", true);
        modelmap.put("list", reserveList);
        return modelmap;
    }

    @RequestMapping(value = "/getreservedetail", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getReserveDetail(HttpServletRequest request) {
        Map<String, Object> modelmap = new HashMap<>();
        Long reserveid = Long.parseLong(request.getParameter("reserveid"));
        Reserve reserve = userReserveService.selectSingleReservelist(reserveid);
        modelmap.put("success", true);
        modelmap.put("result", reserve);
        return modelmap;
    }
}
