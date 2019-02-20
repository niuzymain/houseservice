package com.house.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

/*
校验验证码工具类
 */
public class CheckCodeUtil {
    public static boolean isCodeEqual(HttpServletRequest request){
        String codeexpect = (String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        String inputcode = (String)request.getParameter("checkcode");
        if(codeexpect.equals(inputcode)){
            return true;
        }
        else{
            return false;
        }
    }
}
