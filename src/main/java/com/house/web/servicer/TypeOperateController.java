package com.house.web.servicer;

import com.house.service.superadmin.typeDisplay;
import com.house.service.superadmin.typeOperate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/admin" )
public class TypeOperateController {
    @Autowired
    private typeDisplay typeDisplay;
    @Autowired
    private typeOperate typeOperate;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Map<String,Object> getTypeList(){

    }
}
