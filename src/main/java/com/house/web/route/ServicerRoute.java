package com.house.web.route;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/servicer")
public class ServicerRoute {

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    private String servicerRegister(){
        return"servicer/register";
    }

    @RequestMapping(value = "/reserve",method = RequestMethod.GET)
    private String servicerReserve(){
        return"servicer/reserve";
    }

    @RequestMapping(value = "/reservedetail",method = RequestMethod.GET)
    private String servicerReserveDetail(){
        return"servicer/reservedetail";
    }

    @RequestMapping(value = "/displayinfo",method = RequestMethod.GET)
    private String servicerDisplay(){
        return"servicer/displayinfo";
    }

    @RequestMapping(value = "/editinfo",method = RequestMethod.GET)
    private String servicerEdit(){
        return"servicer/editinfo";
    }

    @RequestMapping(value = "/evaluate",method = RequestMethod.GET)
    private String servicerSvaluate(){
        return"servicer/evaluate";
    }
}
