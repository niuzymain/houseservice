package com.house.web.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.house.entity.*;
import com.house.service.common.CommonService;
import com.house.service.servicer.ServicerService;
import com.house.service.superadmin.AdminService;
import com.house.service.user.UserService;
import com.house.util.CheckCodeUtil;
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
通用功能controller
 */
@Controller
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private AdminService adminService;
    @Autowired

    private UserService userService;

    @Autowired
    private ServicerService servicerService;

    @Autowired
    private CommonService commonService;

    @RequestMapping(value = "/checklogin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> checkLogin(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
//        boolean checkcode = CheckCodeUtil.isCodeEqual(request);
//        if(!checkcode){
//            modelMap.put("success",false);
//            modelMap.put("errormsg","验证码不正确");
//            return modelMap;
//        }
        Object account = null;
        String loginstr = request.getParameter("loginstr");
        String accounttype = request.getParameter("type");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if (accounttype.equals("user")) {
                User user = objectMapper.readValue(loginstr, User.class);
                account = userService.selectSingleUser(user);
                if (account == null) {
                    modelMap.put("success", false);
                    modelMap.put("errormsg", "用户不存在");
                } else if (((User) account).getEnablestatus() == 0 || ((User) account).getEnablestatus() == -1) {
                    modelMap.put("success", false);
                    modelMap.put("errormsg", "账户不可用");
                } else {
                    modelMap.put("success", true);
///////////////////////////这里session添加个人信息，根据accountid查找/////////////////////////////////////////
                    request.getSession().setAttribute("useraccount", account);
/////////////////////////添加跳转路由///////////////////////////////////////////////////////
                    modelMap.put("route", "/user/main");
                }
            } else if (accounttype.equals("servicer")) {
                Servicer servicer = objectMapper.readValue(loginstr, Servicer.class);
                account = servicerService.selectSingleServicer(servicer);
                if (account == null) {
                    modelMap.put("success", false);
                    modelMap.put("errormsg", "用户不存在");
                } else if (((Servicer) account).getEnablestatus() == 0 || ((Servicer) account).getEnablestatus() == -1) {
                    modelMap.put("success", false);
                    modelMap.put("errormsg", "账户不可用");
                } else {
                    modelMap.put("success", true);
///////////////////////////这里session添加个人信息，根据accountid查找/////////////////////////////////////////
                    request.getSession().setAttribute("serviceraccount", account);
                    modelMap.put("route", "/servicer/reserve");
                }
            } else if (accounttype.equals("admin")) {
                SuperAdmin superAdmin = objectMapper.readValue(loginstr, SuperAdmin.class);
                account = adminService.checkLogin(superAdmin);
                if (account != null) {
                    modelMap.put("success", true);
///////////////////////////这里session添加个人信息，根据accountid查找/////////////////////////////////////////
                    request.getSession().setAttribute("adminaccount", account);
                } else {
                    modelMap.put("success", false);
                    modelMap.put("errormsg", "管理员不存在");
                }
            } else {
                modelMap.put("success", false);
                modelMap.put("errormsg", "用户类型为空");
            }
            return modelMap;
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errormsg", "错误信息:" + e.getMessage());
            return modelMap;
        }
    }

    @RequestMapping(value = "/getitemlist", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getItemList() {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            List<WorkArea> workAreaList = commonService.getCitys();
            List<ServiceType> serviceTypeList = commonService.getServicetype();
            List<Degree> degreeList = commonService.getDegree();
            modelMap.put("success", true);
            modelMap.put("citys", workAreaList);
            modelMap.put("types", serviceTypeList);
            modelMap.put("degrees", degreeList);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errormsg", e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/getlocals", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getLocals(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        Long parentid = Long.parseLong(request.getParameter("parentid"));
        List<WorkArea> workAreaList = new ArrayList<>();
        try {
            workAreaList = commonService.getLocals(parentid);
            modelMap.put("success", true);
            modelMap.put("locals", workAreaList);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errormsg", e.getMessage());
        }
        return modelMap;
    }
}
