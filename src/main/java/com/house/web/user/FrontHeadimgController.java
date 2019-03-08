package com.house.web.user;

import com.house.dto.HeadimgExecution;
import com.house.entity.User;
import com.house.enums.HeadimgEnum;
import com.house.service.user.FrontHeadimgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.HashMap;

@Controller
@RequestMapping("/user")
public class FrontHeadimgController {
    @Autowired
    private FrontHeadimgService frontHeadimgService;

    @RequestMapping(value = "/getheadimglist",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getHeadimgList(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("useraccount");
        Map<String,Object> modelmap = new HashMap<>();
        try{
            HeadimgExecution he = frontHeadimgService.checkHeadimg();
            if(he.getState() == HeadimgEnum.SUCCESS.getState()){
                modelmap.put("success",true);
                modelmap.put("result",he.getHeadimgList());
                modelmap.put("account",user);
            }
            else{
                modelmap.put("success",false);
                modelmap.put("errormsg",he.getStateinfo());
            }
            return modelmap;
        }catch (Exception e){
            e.printStackTrace();
            modelmap.put("success",false);
            modelmap.put("errormsg",e.getMessage());
            return modelmap;
        }
    }

    @RequestMapping(value = "/getspecificheadimg",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSpecificHeadimg(HttpServletRequest request){
        Map<String,Object> modelmap = new HashMap<>();
        Long headimgid = Long.parseLong(request.getParameter("headimgid"));
        try{
            HeadimgExecution he = frontHeadimgService.checkSpecificHeadimg(headimgid);
            if(he.getState() == HeadimgEnum.SUCCESS.getState()){
                modelmap.put("success",true);
                modelmap.put("result",he.getHeadimg());
            }
            else{
                modelmap.put("success",false);
                modelmap.put("errormsg",he.getStateinfo());
            }
            return modelmap;
        }catch (Exception e){
            e.printStackTrace();
            modelmap.put("success",false);
            modelmap.put("errormsg",e.getMessage());
            return modelmap;
        }
    }
}
