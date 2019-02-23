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
}
