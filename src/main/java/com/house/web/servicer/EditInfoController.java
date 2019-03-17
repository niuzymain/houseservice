package com.house.web.servicer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.house.dto.ServicerExecution;
import com.house.entity.Servicer;
import com.house.enums.ServicerEnum;
import com.house.service.servicer.EditInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/servicer")
public class EditInfoController {
    @Autowired
    private EditInfoService editInfoService;

    @RequestMapping(value = "/getservicerinfo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getServicerInfo(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        Servicer servicer = (Servicer) request.getSession().getAttribute("serviceraccount");
        ServicerExecution se = editInfoService.getServicerInfo(servicer);
        if (se.getState() == ServicerEnum.SUCCESS.getState()) {
            modelMap.put("success", true);
            modelMap.put("result", se.getServicer());
        } else {
            modelMap.put("success", false);
            modelMap.put("errormsg", se.getStateinfo());
        }
        return modelMap;
    }

    @RequestMapping(value = "/editservicerregisterinfo",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> editServicerRegisterInfo(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        String servicerstr = request.getParameter("str");
        Servicer currentservicer = (Servicer)request.getSession().getAttribute("serviceraccount");
        try{
            Servicer servicer = objectMapper.readValue(servicerstr,Servicer.class);
            servicer.setServicerid(currentservicer.getServicerid());
//////////////////////////////处理文件/////////////////////////////////////////////////////////////////////
            CommonsMultipartFile img = null;
            CommonsMultipartFile file = null;
            CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            if(commonsMultipartResolver.isMultipart(request)){
                //强转为对应request
                MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
                img = (CommonsMultipartFile) multipartHttpServletRequest.getFile("img");
                file = (CommonsMultipartFile) multipartHttpServletRequest.getFile("file");
            }
            ServicerExecution se = new ServicerExecution();
            if(img == null && file == null){
                se = editInfoService.editInfo(servicer);
            }
            else if(img != null && file == null){
                se = editInfoService.editInfo(servicer,img.getInputStream(),img.getOriginalFilename());
            }
            else if(img == null && file != null){
                se = editInfoService.editInfo(servicer,file.getInputStream(),file.getOriginalFilename());
            }
            else{
                se = editInfoService.editInfo(servicer,img.getInputStream(),img.getOriginalFilename(),file.getInputStream(),file.getOriginalFilename());
            }
            if(se.getState() == ServicerEnum.SUCCESS.getState()){
                modelMap.put("success",true);
            }
            else{
                modelMap.put("success",false);
                modelMap.put("errormsg",se.getStateinfo());
            }
            return modelMap;
        }catch (Exception e){
            e.printStackTrace();
            modelMap.put("success",false);
            modelMap.put("errormsg",e.getMessage());
            return modelMap;
        }

    }

    @RequestMapping(value = "/editservicerinfo", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editServicerInfo(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        String servicerstr = request.getParameter("str");
        Servicer currentservicer = (Servicer) request.getSession().getAttribute("serviceraccount");
        try {
            Servicer servicer = objectMapper.readValue(servicerstr, Servicer.class);
            servicer.setServicerid(currentservicer.getServicerid());
            ServicerExecution se = editInfoService.editBaseInfo(servicer);
            if (se.getState() == ServicerEnum.SUCCESS.getState()) {
                modelMap.put("success", true);
                request.getSession().setAttribute("serviceraccount",editInfoService.getServicerInfo(servicer).getServicer());
            }
            else {
                modelMap.put("success", false);
                modelMap.put("errormsg", se.getStateinfo());
            }
            return modelMap;
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errormsg", e.getMessage());
            return modelMap;
        }

    }
}
