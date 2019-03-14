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

    @RequestMapping(value = "/displayareas",method = RequestMethod.GET)
    private String DisplayAreas(){
        return "superadmin/showareas";
    }

    @RequestMapping(value = "/displaytypes",method = RequestMethod.GET)
    private String DisplayTypes(){
        return "superadmin/showtypes";
    }

    @RequestMapping(value = "/displaydegrees",method = RequestMethod.GET)
    private String DisplayDegrees(){
        return "superadmin/showdegrees";
    }

    @RequestMapping(value = "/displaylocals",method = RequestMethod.GET)
    private String displayAreas(){
        return "superadmin/localareas";
    }

    @RequestMapping(value = "/headimg",method = RequestMethod.GET)
    private String headImg(){
        return "superadmin/headimg";
    }

    @RequestMapping(value = "/qualify",method = RequestMethod.GET)
    private String Qualify(){
        return "superadmin/qualify";
    }

    @RequestMapping(value = "/operateheadimg",method = RequestMethod.GET)
    private String operateHeadimg(){
        return "superadmin/operateheadimg";
    }

    @RequestMapping(value = "/qualifydetail",method = RequestMethod.GET)
    private String qualifyDetail(){
        return "superadmin/qualifydetail";
    }

    @RequestMapping(value = "/comment",method = RequestMethod.GET)
    private String checkComment(){
        return "superadmin/comment";
    }

    @RequestMapping(value = "/reserve",method = RequestMethod.GET)
    private String checkReserve(){
        return "superadmin/reserve";
    }

    @RequestMapping(value = "/confirmpage",method = RequestMethod.GET)
    private String reserveConfirm() {
        return "superadmin/confirmpage";

    }
}
