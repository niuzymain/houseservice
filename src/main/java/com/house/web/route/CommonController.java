package com.house.web.route;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class CommonController {
    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    private String adminLogin(){
        return"";
    }
    @RequestMapping(value = "/common",method = RequestMethod.GET)
    private String commonLogin(){
        return"";
    }
}
