package com.house.web.superadmin;

import com.house.entity.Conditions;
import com.house.entity.WorkArea;
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
public class TypeDisplayController {
    @Autowired
    private TypeDisplay typeDisplay;
    @Autowired
    private TypeOperate typeOperate;
    @RequestMapping(value = "/getitems",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getItemList(HttpServletRequest request){
        List<Conditions> conditionsList = new ArrayList<>();
        Map<String,Object> modelMap = new HashMap<>();
        String type = request.getParameter("type");
        if(type == null){
            modelMap.put("success",false);
            modelMap.put("errormsg","信息不全");
        }
        else{
            conditionsList = typeDisplay.Display(type);
            modelMap.put("result", conditionsList);
            modelMap.put("success", true);

        }
        return modelMap;
    }
    @RequestMapping(value = "/getcityareas",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAreaList(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        Long parentid = Long.parseLong(request.getParameter("parentid"));
        if(parentid == null){
            modelMap.put("success",false);
            modelMap.put("errormsg","信息不全");
        }
        else{
            List<WorkArea> workAreaList = new ArrayList<>();
            workAreaList = typeDisplay.displayChildArea(parentid);
            modelMap.put("result", workAreaList);
            modelMap.put("success", true);
        }
        return modelMap;
    }
}
