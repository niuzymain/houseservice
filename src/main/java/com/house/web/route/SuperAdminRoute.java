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

    @RequestMapping(value = "/headimg",method = RequestMethod.GET)
    private String headImg(){
        return "superadmin/headimg";
    }

    @RequestMapping(value = "/servicer",method = RequestMethod.GET)
    private String Qualify(){
        return "superadmin/servicer";
    }

    @RequestMapping(value = "/addadmin",method = RequestMethod.GET)
    private String addAdmin(){
        return "superadmin/addadmin";
    }

    @RequestMapping(value = "/operateheadimg",method = RequestMethod.GET)
    private String operateHeadimg(){
        return "superadmin/operateheadimg";
    }


}
