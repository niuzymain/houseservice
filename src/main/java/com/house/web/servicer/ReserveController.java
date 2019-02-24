package com.house.web.servicer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.house.dto.ServicerExecution;
import com.house.entity.Reserve;
import com.house.entity.Servicer;
import com.house.service.servicer.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/servicer")
public class ReserveController {
    @Autowired
    private ReserveService reserveService;

    @RequestMapping(value = "/getreservelist",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getReserveList(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        Integer enablestatus = Integer.parseInt(request.getParameter("enablestatus"));
        Servicer servicer = (Servicer) request.getSession().getAttribute("accountinfo");
        Reserve reserve = new Reserve();
        reserve.setServicer(servicer);
        reserve.setEnablestatus(enablestatus);
        try{
            List<Reserve> reserveList = reserveService.getReserveList(reserve);
            modelMap.put("success",true);
            modelMap.put("result",reserveList);
            return modelMap;
        }catch (Exception e){
            e.printStackTrace();
            modelMap.put("success",false);
            modelMap.put("errormsg",e.getMessage());
            return modelMap;
        }
    }

    @RequestMapping(value = "/getreservedetail",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getReserveDetail(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        Long reserveid = Long.parseLong(request.getParameter("reserveid"));
        try{
            Reserve reserve = reserveService.getSingleReserve(reserveid);
            modelMap.put("success",true);
            modelMap.put("result",reserve);
            return modelMap;
        }catch (Exception e){
            e.printStackTrace();
            modelMap.put("success",false);
            modelMap.put("errormsg",e.getMessage());
            return modelMap;
        }
    }

    @RequestMapping(value = "/operatereserve",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> OperateReserve(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        String reservestr = request.getParameter("reservestr");
        String status = request.getParameter("status");
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            Reserve reserve = objectMapper.readValue(reservestr,Reserve.class);
            ServicerExecution servicerExecution = reserveService.operateReserve(reserve,status);
            if(servicerExecution.getState() != 1){
                modelMap.put("success",false);
                modelMap.put("errormsg",servicerExecution.getStateinfo());
            }
            else{
                modelMap.put("success",true);
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
