package com.house.web.user;

import com.house.entity.Servicer;
import com.house.entity.User;
import com.house.service.user.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequestMapping("/user")
public class FrontRecommendController {
    @Autowired
    private RecommendService recommendService;

    @RequestMapping(value = "getrecommendservicer", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getRecommendServicer(HttpServletRequest request) {
        Map<String, Object> modelmap = new HashMap<>();
        try {
            User currentuser = (User) request.getSession().getAttribute("useraccount");
            if(currentuser == null){
                modelmap.put("success", true);
                modelmap.put("list", null);
            }
            else{
                List<Servicer> servicerList = recommendService.findRecommendServicer(currentuser.getUserid());
                modelmap.put("success", true);
                modelmap.put("list", servicerList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            modelmap.put("success", false);
            modelmap.put("errormsg", e.getMessage());
        }
        return modelmap;
    }
}
