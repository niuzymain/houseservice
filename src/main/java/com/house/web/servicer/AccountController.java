package com.house.web.servicer;

import com.house.entity.Servicer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/servicer")
public class AccountController {

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> Logout(HttpServletRequest request){
        Map<String,Object> modelmap = new HashMap<>();
        request.getSession().setAttribute("serviceraccount",null);
        modelmap.put("success",true);
        return modelmap;
    }
}
