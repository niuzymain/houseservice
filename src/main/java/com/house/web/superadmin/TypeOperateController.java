package com.house.web.superadmin;

import com.house.entity.Conditions;
import com.house.service.superadmin.TypeDisplay;
import com.house.service.superadmin.TypeOperate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
展示类别controller
 */
@Controller
@RequestMapping("/admin" )
public class TypeOperateController {
    @Autowired
    private TypeDisplay typeDisplay;
    @Autowired
    private TypeOperate typeOperate;
}
