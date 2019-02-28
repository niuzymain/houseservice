package com.house.web.servicer;

import com.house.entity.AdminMsg;
import com.house.entity.Servicer;
import com.house.service.servicer.MessageService;
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
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/getmessagelist", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getServicerInfo(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            Servicer servicer = (Servicer) request.getSession().getAttribute("accountinfo");
            List<AdminMsg> adminMsgList = messageService.checkMessage(servicer);
            modelMap.put("success", true);
            modelMap.put("result", adminMsgList);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errormsg", e.getMessage());
        }
        return modelMap;
    }
}
