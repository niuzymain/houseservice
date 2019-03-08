package com.house.web.servicer;

import com.house.entity.Evaluate;
import com.house.entity.Servicer;
import com.house.service.servicer.EvaluateService;
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
@RequestMapping("/servicer")
public class EvaluateController {
    @Autowired
    private EvaluateService evaluateService;

    @RequestMapping(value = "/getevaluatelist",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEvaluateList(HttpServletRequest request){
        Map<String,Object> modelmap = new HashMap<>();
        try{
            Servicer servicer = (Servicer) request.getSession().getAttribute("serviceraccount");
            List<Evaluate> evaluateList = evaluateService.checkEvaluate(servicer);
            modelmap.put("success",true);
            modelmap.put("result",evaluateList);
        }catch (Exception e) {
            e.printStackTrace();
            modelmap.put("success",false);
            modelmap.put("errormsg",e.getMessage());
        }
        return modelmap;
    }
}
