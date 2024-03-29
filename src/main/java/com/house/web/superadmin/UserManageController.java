package com.house.web.superadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.house.dto.ServicerExecution;
import com.house.dto.UserExecution;
import com.house.entity.Servicer;
import com.house.entity.User;
import com.house.service.servicer.ServicerService;
import com.house.service.superadmin.UserInfoManage;
import com.house.service.user.UserService;
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

@Controller
@RequestMapping("/admin")
public class UserManageController {
    @Autowired
    private UserInfoManage userInfoManage;

    @Autowired
    private UserService userService;

    @Autowired
    private ServicerService servicerService;

    @RequestMapping(value = "/editstatus", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editStatus(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        String operatestr = request.getParameter("operatestr");//json串
        String accounttype = request.getParameter("type");
        ObjectMapper objectMapper = new ObjectMapper();
        Object obj = null;
        int result = 0;
        try {
            if (accounttype.equals("user")) {
                obj = objectMapper.readValue(operatestr, User.class);
                result = userService.editUser((User) obj);
            } else {
                obj = objectMapper.readValue(operatestr, Servicer.class);
                result = servicerService.editServicer((Servicer) obj);
            }
            if (result <= 0) {
                modelMap.put("success", false);
                modelMap.put("errormsg", "操作失败");
            } else {
                modelMap.put("success", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errormsg", e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUserlist(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        int pageIndex = Integer.parseInt(request.getParameter("pageindex"));
        int pageSize = Integer.parseInt(request.getParameter("pagesize"));
        try {
            UserExecution userExecution = userInfoManage.getUserList(pageIndex,pageSize);
            modelMap.put("success", true);
            modelMap.put("result", userExecution.getUserList());
            modelMap.put("count", userExecution.getUsercount());
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errormsg", e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/singleuser", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUserById(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        Long userid = Long.parseLong(request.getParameter("userid"));
        User user = new User();
        try {
            user = userInfoManage.getUserById(userid);
            modelMap.put("success", true);
            modelMap.put("result", user);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errormsg", e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/servicerlist", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getServicerList(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        int pageIndex = Integer.parseInt(request.getParameter("pageindex"));
        int pageSize = Integer.parseInt(request.getParameter("pagesize"));
        try {
            ServicerExecution servicerExecution = userInfoManage.getServicerList(pageIndex,pageSize);
            modelMap.put("success", true);
            modelMap.put("result", servicerExecution.getServicerList());
            modelMap.put("count", servicerExecution.getServicercount());
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errormsg", e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/singleservicer", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getServicerById(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        Long servicerid = Long.parseLong(request.getParameter("servicerid"));
        Servicer condition = new Servicer();
        condition.setServicerid(servicerid);
        try {
            Servicer servicer = userInfoManage.getSingleServicer(condition);
            modelMap.put("success", true);
            modelMap.put("result", servicer);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errormsg", e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/unemployment", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> UnemploymentServicer(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        Long servicerid = Long.parseLong(request.getParameter("servicerid"));
        try {
            int result = userInfoManage.Unemployment(servicerid);
            if (result > 0) {
                modelMap.put("success", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errormsg", e.getMessage());
        }
        return modelMap;
    }
}
