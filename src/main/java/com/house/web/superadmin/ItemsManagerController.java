package com.house.web.superadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.house.entity.Conditions;
import com.house.entity.WorkArea;
import com.house.service.superadmin.ItemsDisplay;
import com.house.service.superadmin.ItemsOperate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
编辑和展示类别controller
 */
@Controller
@RequestMapping("/admin" )
public class ItemsManagerController {
    @Autowired
    private ItemsDisplay itemsDisplay;
    @Autowired
    private ItemsOperate itemsOperate;

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
            conditionsList = itemsDisplay.Display(type);
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
            workAreaList = itemsDisplay.displayChildArea(parentid);
            modelMap.put("result", workAreaList);
            modelMap.put("success", true);
        }
        return modelMap;
    }

    @RequestMapping(value = "/operate",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> OperateItems(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        String operatestr = request.getParameter("operatestr");
        String operatetype = request.getParameter("operate");
        int result;
        ObjectMapper objectMapper = new ObjectMapper();
        Conditions conditions = null;
        try {
            conditions = objectMapper.readValue(operatestr,Conditions.class);
            if(operatetype.equals("新增")){
                result = itemsOperate.addCondition(conditions);
            }
            else if(operatetype.equals("编辑")){
                result = itemsOperate.updateCondition(conditions);
            }
            else if(operatetype.equals("删除")){
                result = itemsOperate.deleteCondition(conditions);
            }
            else{
                modelMap.put("success",false);
                modelMap.put("errormsg","非法操作");
                return modelMap;
            }
            if(result == 1){
                modelMap.put("success",true);
            }
            else{
                modelMap.put("success",false);
                modelMap.put("errormsg","操作失败");
            }
            return modelMap;

        } catch (IOException e) {
            e.printStackTrace();
            modelMap.put("success",false);
            modelMap.put("errormsg","错误："+e.getMessage());
            return modelMap;
        }
    }

}
