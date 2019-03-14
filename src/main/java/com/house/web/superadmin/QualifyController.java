package com.house.web.superadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.house.entity.AdminMsg;
import com.house.entity.Evaluate;
import com.house.entity.Reserve;
import com.house.entity.Servicer;
import com.house.service.superadmin.QualifyCommentService;
import com.house.service.superadmin.QualifyReserveService;
import com.house.service.superadmin.QualifyServicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class QualifyController {
    @Autowired
    private QualifyServicer qualifyServicer;

    @Autowired
    private QualifyReserveService qualifyReserveService;

    @Autowired
    private QualifyCommentService qualifyCommentService;

    @RequestMapping(value = "/getqualifylist", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getQualifyList() {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            List<Servicer> servicerList = qualifyServicer.servicerQualifyList();
            modelMap.put("success", true);
            modelMap.put("result", servicerList);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errormsg", e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/getqualifydetail", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getQualifyDetail(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        Long servicerid = Long.parseLong(request.getParameter("servicerid"));
        try {
            Servicer servicer = qualifyServicer.getServicerQualifyById(servicerid);
            modelMap.put("success", true);
            modelMap.put("result", servicer);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errormsg", e.getMessage());
        }
        return modelMap;

    }

    @RequestMapping(value = "/qualifyoperate", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> QualifyOperate(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        String msgstr = request.getParameter("adminmsg");
        String servicerstr = request.getParameter("servicer");
        ObjectMapper objectMapper = new ObjectMapper();
        int result;
        try {
            Servicer servicer = objectMapper.readValue(servicerstr, Servicer.class);
            if (msgstr != null) {
                AdminMsg adminMsg = objectMapper.readValue(msgstr, AdminMsg.class);
                result = qualifyServicer.servicerQualifyOperate(adminMsg, servicer);
            } else {
                result = qualifyServicer.servicerQualifyOperate(null, servicer);
            }
            if (result > 0) {
                modelMap.put("success", true);
            } else {
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

    @RequestMapping(value = "/getcommentlist", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getCommentList(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            List<Evaluate> evaluateList = qualifyCommentService.commentQualifyList();
            modelMap.put("success", true);
            modelMap.put("list", evaluateList);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errormsg", e.getMessage());
        }
        return modelMap;

    }

    @RequestMapping(value = "/illegalcommentoperate", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> commentOperate(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        Long evaluateid = Long.parseLong(request.getParameter("evaluateid"));
        int result;
        try {
            result = qualifyCommentService.illegalCommentOperate(evaluateid);
            if (result > 0) {
                modelMap.put("success", true);
            } else {
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

    @RequestMapping(value = "/getreservelist", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getReserveList(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        int enablestatus = Integer.parseInt(request.getParameter("status"));
        try {
            List<Reserve> reserveList = qualifyReserveService.reserveQualifyList(enablestatus);
            modelMap.put("success", true);
            modelMap.put("list", reserveList);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errormsg", e.getMessage());
        }
        return modelMap;

    }

    @RequestMapping(value = "/getspecificreserve", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getSpecificReserveList(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        Long reserveid = Long.parseLong(request.getParameter("reserveid"));
        try {
           Reserve reserve = qualifyReserveService.specificReserveQualify(reserveid);
            modelMap.put("success", true);
            modelMap.put("result", reserve);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errormsg", e.getMessage());
        }
        return modelMap;

    }

    @RequestMapping(value = "/handlereserve", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> handleReserve(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        Long reserveid = Long.parseLong(request.getParameter("reserveid"));
        try {
            int result = qualifyReserveService.handleReserve(reserveid);
            if(result > 0){
                modelMap.put("success", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errormsg", e.getMessage());
        }
        return modelMap;

    }

    @RequestMapping(value = "/confirmereserve", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> confirmReserve(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        String reservestr = request.getParameter("reservestr");
        try {
            Reserve reserve = objectMapper.readValue(reservestr,Reserve.class);
            CommonsMultipartFile commonsMultipartFile = null;
            CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            //判断是否有文件流
            if(commonsMultipartResolver.isMultipart(request)){
                //强转为对应request
                MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
                commonsMultipartFile = (CommonsMultipartFile) multipartHttpServletRequest.getFile("contract");
            }
            else{
                modelMap.put("success",false);
                modelMap.put("errormsg","合同不能为空");
                return modelMap;
            }
            if(commonsMultipartFile == null || reserve == null){
                modelMap.put("success",false);
                modelMap.put("errormsg","信息不全");
                return modelMap;
            }
            int result = qualifyReserveService.confirmReserve(reserve,commonsMultipartFile.getInputStream(),commonsMultipartFile.getOriginalFilename());
            if(result > 0){
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
