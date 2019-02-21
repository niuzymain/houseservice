package com.house.web.servicer;

import com.house.entity.Degree;
import com.house.entity.ServiceType;
import com.house.entity.WorkArea;
import com.house.service.servicer.RegisterService;
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
@RequestMapping("/servicer")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/getitemlist",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getItemList(){
        Map<String,Object> modelMap = new HashMap<>();
        try{
            List<WorkArea> workAreaList = registerService.getCitys();
            List<ServiceType> serviceTypeList = registerService.getServicetype();
            List<Degree> degreeList = registerService.getDegree();
            modelMap.put("success",true);
            modelMap.put("citys",workAreaList);
            modelMap.put("types",serviceTypeList);
            modelMap.put("degrees",degreeList);
        }catch (Exception e){
            e.printStackTrace();
            modelMap.put("success",false);
            modelMap.put("errormsg",e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/getlocals",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getLocals(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        Long parentid = Long.parseLong(request.getParameter("parentid"));
        List<WorkArea> workAreaList = new ArrayList<>();
        try{
            workAreaList = registerService.getLocals(parentid);
            modelMap.put("success",true);
            modelMap.put("locals",workAreaList);
        }catch (Exception e){
            e.printStackTrace();
            modelMap.put("success",false);
            modelMap.put("errormsg",e.getMessage());
        }
        return modelMap;
    }
}
