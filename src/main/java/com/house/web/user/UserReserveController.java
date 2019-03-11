package com.house.web.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.house.entity.Reserve;
import com.house.entity.User;
import com.house.service.user.UserReserveService;
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
public class UserReserveController {
    @Autowired
    private UserReserveService userReserveService;

    @RequestMapping(value = "/addreserve",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addReserve(HttpServletRequest request){
        Map<String,Object> modelmap = new HashMap<>();
        User user = (User)request.getSession().getAttribute("useraccount");
        String reservestr = request.getParameter("reservestr");
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            Reserve reserve = objectMapper.readValue(reservestr,Reserve.class);
            reserve.setUser(user);
            int result = userReserveService.createReserve(reserve);
            if(result > 0){
                modelmap.put("success",true);
            }
            return modelmap;
        }catch (Exception e){
            e.printStackTrace();
            modelmap.put("success",false);
            modelmap.put("errormsg",e.getMessage());
            return modelmap;
        }
    }

    @RequestMapping(value = "/cancelreserve",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> cancelReserve(HttpServletRequest request){
        Map<String,Object> modelmap = new HashMap<>();
        String reservestr = request.getParameter("reservestr");
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            Reserve reserve = objectMapper.readValue(reservestr,Reserve.class);
            int result = userReserveService.cancelReserve(reserve);
            if(result > 0){
                modelmap.put("success",true);
            }
            return modelmap;
        }catch (Exception e){
            e.printStackTrace();
            modelmap.put("success",false);
            modelmap.put("errormsg",e.getMessage());
            return modelmap;
        }
    }
}
