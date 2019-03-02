package com.house.web.servicer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.house.entity.Degree;
import com.house.entity.ServiceType;
import com.house.entity.Servicer;
import com.house.entity.WorkArea;
import com.house.service.common.CommonService;
import com.house.service.servicer.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

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

    @Autowired
    private CommonService commonService;

    @RequestMapping(value = "/getitemlist",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getItemList(){
        Map<String,Object> modelMap = new HashMap<>();
        try{
            List<WorkArea> workAreaList = commonService.getCitys();
            List<ServiceType> serviceTypeList = commonService.getServicetype();
            List<Degree> degreeList = commonService.getDegree();
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
            workAreaList = commonService.getLocals(parentid);
            modelMap.put("success",true);
            modelMap.put("locals",workAreaList);
        }catch (Exception e){
            e.printStackTrace();
            modelMap.put("success",false);
            modelMap.put("errormsg",e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/registeroperate",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> RegisterOperate(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        String registerstr = request.getParameter("register");
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            Servicer servicer = objectMapper.readValue(registerstr,Servicer.class);
            CommonsMultipartFile img = null;
            CommonsMultipartFile file = null;
            CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            if(commonsMultipartResolver.isMultipart(request)){
                //强转为对应request
                MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
                img = (CommonsMultipartFile) multipartHttpServletRequest.getFile("img");
                file = (CommonsMultipartFile) multipartHttpServletRequest.getFile("file");
            }
            else{
                modelMap.put("success",false);
                modelMap.put("errormsg","图片不能为空");
                return modelMap;
            }
            if(servicer != null && img != null && file != null){
                int result = registerService.addServicer(servicer,img.getInputStream(),img.getOriginalFilename(),file.getInputStream(),file.getOriginalFilename());
                if(result <= 0){
                    modelMap.put("success",false);
                    modelMap.put("errormsg","内部错误");
                }
                else{
                    modelMap.put("success",true);
                }
            }
            else{
                modelMap.put("success",false);
                modelMap.put("errormsg","信息不全");
            }
            return modelMap;
        }catch (Exception e){
            e.printStackTrace();
            modelMap.put("success",false);
            modelMap.put("errormsg",e.getMessage());
            return modelMap;
        }
    }
}
