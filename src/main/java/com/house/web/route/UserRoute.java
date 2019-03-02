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
}
