package com.house.web.superadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.house.dto.HeadimgExecution;
import com.house.entity.Headimg;
import com.house.enums.HeadimgEnum;
import com.house.service.superadmin.HeadimgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class HeadimgController {
    @Autowired
    private HeadimgService headimgService;

    @RequestMapping(value = "/addheadimg",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> AddHeadimg(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        String operatestr = request.getParameter("operatestr");//json串
        ObjectMapper objectMapper = new ObjectMapper();
        Headimg headimg = new Headimg();
        try {
            headimg = objectMapper.readValue(operatestr,Headimg.class);
            CommonsMultipartFile imgfile = null;
            CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            //判断是否有文件流
            if(commonsMultipartResolver.isMultipart(request)){
                //强转为对应request
                MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
                imgfile = (CommonsMultipartFile) multipartHttpServletRequest.getFile("imgfile");
            }
            else{
                modelMap.put("success",false);
                modelMap.put("errormsg","图片不能为空");
                return modelMap;
            }
            //添加轮播图
            if(headimg != null && imgfile != null){
                HeadimgExecution he = headimgService.AddHeadimg(headimg,imgfile.getInputStream(),imgfile.getOriginalFilename());
                if(he.getState() != HeadimgEnum.SUCCESS.getState()){
                    modelMap.put("success",false);
                    modelMap.put("errormsg",he.getStateinfo());
                }
                else{
                    modelMap.put("success",true);
                }
            }
            else{
                modelMap.put("success",false);
                modelMap.put("errormsg","信息不全");
                return modelMap;
            }
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success",false);
            modelMap.put("errormsg",e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/editheadimg",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> EditHeadimg(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        String operatestr = request.getParameter("operatestr");//json串
        ObjectMapper objectMapper = new ObjectMapper();
        Headimg headimg = new Headimg();
        try {
            headimg = objectMapper.readValue(operatestr,Headimg.class);
            CommonsMultipartFile imgfile = null;
            CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            //判断是否有文件流
            if(commonsMultipartResolver.isMultipart(request)){
                //强转为对应request
                MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
                imgfile = (CommonsMultipartFile) multipartHttpServletRequest.getFile("imgfile");
            }
            //添加轮播图
            HeadimgExecution he = new HeadimgExecution();
            if(imgfile == null){
                he = headimgService.UpdataHeadimg(headimg,null,null);
            }
            else{
                he = headimgService.UpdataHeadimg(headimg,imgfile.getInputStream(),imgfile.getOriginalFilename());
            }
            if(he.getState() != HeadimgEnum.SUCCESS.getState()){
                modelMap.put("success",false);
                modelMap.put("errormsg",he.getStateinfo());
            }
            else{
                modelMap.put("success",true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success",false);
            modelMap.put("errormsg",e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/delheadimg",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> DelHeadimg(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        Long headimgid = Long.parseLong(request.getParameter("headimgid"));
        try {
            HeadimgExecution he = headimgService.DeleteHeadimg(headimgid);
            if(he.getState() != HeadimgEnum.SUCCESS.getState()){
                modelMap.put("success",false);
                modelMap.put("errormsg",he.getStateinfo());
            }
            else{
                modelMap.put("success",true);
            }
        }catch (Exception e){
            e.printStackTrace();
            modelMap.put("success",false);
            modelMap.put("errormsg",e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/headimglist",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getheadimgList(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        HeadimgExecution he = headimgService.QueryHeadimg();
        List<Headimg> headimgList = new ArrayList<>();
        headimgList = he.getHeadimgList();
        modelMap.put("result",headimgList);
        modelMap.put("success",true);
        return modelMap;
    }

    @RequestMapping(value = "/singleheadimg",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSingleHeadimg(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        HeadimgExecution he = headimgService.getHeadimgById(Long.parseLong(request.getParameter("headimgid")));
        modelMap.put("result",he.getHeadimg());
        modelMap.put("success",true);
        return modelMap;
    }
}
