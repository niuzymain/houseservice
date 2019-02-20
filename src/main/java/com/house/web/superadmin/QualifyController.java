package com.house.web.superadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.house.entity.AdminMsg;
import com.house.entity.Servicer;
import com.house.service.superadmin.QualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class QualifyController {
    @Autowired
    private QualifyService qualifyService;

    @RequestMapping(value = "/getqualifylist",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getQualifyList() {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            List<Servicer> servicerList = qualifyService.qualifyList();
            modelMap.put("success", true);
            modelMap.put("result", servicerList);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errormsg", e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/getqualifydetail",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getQualifyDetail(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        Long servicerid = Long.parseLong(request.getParameter("servicerid"));
        try {
            Servicer servicer = qualifyService.getQualifyById(servicerid);
            modelMap.put("success", true);
            modelMap.put("result", servicer);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errormsg", e.getMessage());
        }
        return modelMap;

    }

    @RequestMapping(value = "/qualifyoperate",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> QualifyOperate(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        String msgstr = request.getParameter("adminmsg");
        String servicerstr = request.getParameter("servicer");
        ObjectMapper objectMapper = new ObjectMapper();
        int result;
        try {
            Servicer servicer = objectMapper.readValue(servicerstr,Servicer.class);
            if(msgstr != null){
                AdminMsg adminMsg  = objectMapper.readValue(msgstr,AdminMsg.class);
                result = qualifyService.qualifyOperate(adminMsg,servicer);
            }
            else{
                result = qualifyService.qualifyOperate(new AdminMsg(),servicer);
            }
            if(result > 0 ){
                modelMap.put("success", true);
            }
            else{
                modelMap.put("success", false);
                modelMap.put("errormsg", "内部错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errormsg", e.getMessage());
        }
        return modelMap;

    }
}
