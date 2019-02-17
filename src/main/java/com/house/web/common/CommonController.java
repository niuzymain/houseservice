package com.house.web.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.house.entity.SuperAdmin;
import com.house.entity.User;
import com.house.service.superadmin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/*
通用功能controller
 */
@Controller
@RequestMapping("/common")
public class CommonController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/checklogin",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> checkLogin(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        Object account = null;
        String loginstr = request.getParameter("loginstr");
        String accounttype = request.getParameter("type");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if(accounttype.equals("用户")){

            }
            else if(accounttype.equals("服务人员")){

            }
            else if(accounttype.equals("管理员")){
                SuperAdmin superAdmin = objectMapper.readValue(loginstr,SuperAdmin.class);
                account = adminService.checkLogin(superAdmin);
            }
            else{
                modelMap.put("success",false);
                modelMap.put("errormsg","用户类型为空");
            }
            if(account != null){
                modelMap.put("success",true);
///////////////////////////这里session添加个人信息，根据accountid查找/////////////////////////////////////////
                request.getSession().setAttribute("accountinfo",account);

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
