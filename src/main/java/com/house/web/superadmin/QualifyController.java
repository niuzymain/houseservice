package com.house.web.superadmin;

import com.house.entity.Servicer;
import com.house.service.superadmin.QualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class QualifyController {
    @Autowired
    private QualifyService qualifyService;

    @RequestMapping("/qualifylist")
    @ResponseBody
    public Map<String,Object> getQualifyList(){
        Map<String,Object> modelMap = new HashMap<>();
        try{
            List<Servicer> servicerList = qualifyService.qualifyList();
            modelMap.put("success",true);
            modelMap.put("result",servicerList);
        }catch (Exception e){
            e.printStackTrace();
            modelMap.put("success",false);
            modelMap.put("errormsg",e.getMessage());
        }
        return modelMap;

    }
}
