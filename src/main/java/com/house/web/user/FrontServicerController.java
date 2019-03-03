package com.house.web.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.house.dto.HeadimgExecution;
import com.house.entity.Servicer;
import com.house.enums.HeadimgEnum;
import com.house.service.user.FrontHeadimgService;
import com.house.service.user.FrontServicerService;
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
@RequestMapping("/user")
public class FrontServicerController {
    @Autowired
    private FrontServicerService frontServicerService;

    @RequestMapping(value = "/getavailableservicer",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getAvailableServicer(HttpServletRequest request){
        Map<String,Object> modelmap = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        String servicerstr = request.getParameter("servicerstr");
        String order = request.getParameter("order");
        int pageindex = Integer.parseInt(request.getParameter("pageindex"));
        int pagesize = Integer.parseInt(request.getParameter("pagesize"));
        try{
            Servicer servicer = objectMapper.readValue(servicerstr,Servicer.class);
            List<Servicer> servicerList = frontServicerService.getAvailableServicer(servicer,order,pageindex,pagesize);
            int servicercount = frontServicerService.ServicerCount(servicer);
            modelmap.put("success",true);
            modelmap.put("list",servicerList);
            modelmap.put("count",servicercount);
            return modelmap;
        }catch (Exception e){
            e.printStackTrace();
            modelmap.put("success",false);
            modelmap.put("errormsg",e.getMessage());
            return modelmap;
        }
    }

    @RequestMapping(value = "/getservicerdetail",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getServicerDetail(HttpServletRequest request){
        Map<String,Object> modelmap = new HashMap<>();
        Long servicerid = Long.parseLong(request.getParameter("servicerid"));
        try{
            Servicer servicer = frontServicerService.getSpecificServicer(servicerid);
            modelmap.put("success",true);
            modelmap.put("result",servicer);
            return modelmap;
        }catch (Exception e){
            e.printStackTrace();
            modelmap.put("success",false);
            modelmap.put("errormsg",e.getMessage());
            return modelmap;
        }
    }
}
