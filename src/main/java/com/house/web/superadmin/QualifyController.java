package com.house.web.superadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.house.entity.AdminMsg;
import com.house.entity.Evaluate;
import com.house.entity.Reserve;
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

    @RequestMapping(value = "/getqualifylist", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getQualifyList() {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            List<Servicer> servicerList = qualifyService.servicerQualifyList();
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
            Servicer servicer = qualifyService.getServicerQualifyById(servicerid);
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
                result = qualifyService.servicerQualifyOperate(adminMsg, servicer);
            } else {
                result = qualifyService.servicerQualifyOperate(null, servicer);
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
            List<Evaluate> evaluateList = qualifyService.commentQualifyList();
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
            result = qualifyService.illegalCommentOperate(evaluateid);
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
            List<Reserve> reserveList = qualifyService.reserveQualifyList(enablestatus);
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
           Reserve reserve = qualifyService.specificReserveQualify(reserveid);
            modelMap.put("success", true);
            modelMap.put("result", reserve);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errormsg", e.getMessage());
        }
        return modelMap;

    }

    @RequestMapping(value = "/reserveoperate", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> reserveOperate(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        String resstr = request.getParameter("resstr");
        ObjectMapper objectMapper = new ObjectMapper();
        int result;
        try {
            Reserve reserve = objectMapper.readValue(resstr, Reserve.class);
            result = qualifyService.reserveQualifyOperate(reserve);
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
}
