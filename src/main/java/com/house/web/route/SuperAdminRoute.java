package com.house.web.route;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class SuperAdminRoute {

    @RequestMapping(value = "/main",method = RequestMethod.GET)
    private String mainPage(){
        return "superadmin/main";
    }

    @RequestMapping(value = "/display",method = RequestMethod.GET)
    private String Display(){
        return "superadmin/showitems";
    }

    @RequestMapping(value = "/displayareas",method = RequestMethod.GET)
    private String displayAreas(){
        return "superadmin/localareas";
    }
}
