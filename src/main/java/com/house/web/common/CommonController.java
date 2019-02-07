package com.house.web.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.house.entity.Account;
import com.house.entity.Conditions;
import com.house.service.common.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
通用功能controller
 */
@Controller
@RequestMapping("/common")
public class CommonController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/checklogin",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> checkLogin(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        String loginstr = request.getParameter("loginstr");
        ObjectMapper objectMapper = new ObjectMapper();
        Account account = null;
        try {
            account = objectMapper.readValue(loginstr,Account.class);
            boolean isExist = loginService.isAccountExist(account);
            if(isExist){
                modelMap.put("success",true);
///////////////////////////这里session添加个人信息，根据accountid查找/////////////////////////////////////////
            }
            else{
                modelMap.put("success",false);
                modelMap.put("errormsg","用户不存在");
            }
            return modelMap;
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success",false);
            modelMap.put("errormsg","错误信息:"+e.getMessage());
            return modelMap;
        }
    }
}
