package com.house.web.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.house.entity.User;
import com.house.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserService userService;

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
        request.getSession().setAttribute("accountinfo", null);
        modelmap.put("success", true);
        return modelmap;
    }

    @RequestMapping(value = "/getuserinfo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUserInfo(HttpServletRequest request) {
        Map<String, Object> modelmap = new HashMap<>();
        request.getSession().setAttribute("accountinfo", null);
        modelmap.put("success", true);
        return modelmap;
    }

    @RequestMapping(value = "/getuserreserve", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUserReserve(HttpServletRequest request) {
        Map<String, Object> modelmap = new HashMap<>();
        request.getSession().setAttribute("accountinfo", null);
        modelmap.put("success", true);
        return modelmap;
    }
}
