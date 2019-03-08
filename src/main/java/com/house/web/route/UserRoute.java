package com.house.web.route;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserRoute {

    @RequestMapping(value = "/main",method = RequestMethod.GET)
    private String userMain(){
        return"user/main";
    }

    @RequestMapping(value = "/headimgdetail",method = RequestMethod.GET)
    private String userHeadimgDetail(){
        return"user/headimgdetail";
    }

    @RequestMapping(value = "/servicerpage",method = RequestMethod.GET)
    private String userServicerPage(){
        return"user/servicerpage";
    }

    @RequestMapping(value = "/servicerdetail",method = RequestMethod.GET)
    private String userServicerDetail(){
        return"user/servicerdetail";
    }

    @RequestMapping(value = "/userinfo",method = RequestMethod.GET)
    private String userInfo(){
        return"user/userinfo";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    private String userRegister(){
        return"user/register";
    }

    @RequestMapping(value = "/reserve",method = RequestMethod.GET)
    private String userReserve(){
        return"user/reserve";
    }

    @RequestMapping(value = "/record",method = RequestMethod.GET)
    private String userRecord(){
        return"user/record";
    }

    @RequestMapping(value = "/evaluate",method = RequestMethod.GET)
    private String userEvaluate(){
        return"user/evaluate";
    }
}
