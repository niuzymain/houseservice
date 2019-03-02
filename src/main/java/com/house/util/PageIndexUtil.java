package com.house.util;

public class PageIndexUtil {
    public static int TranstoDBIndex(int pageindex,int pagesize){
        if(pageindex > 0){
            return (pageindex-1)*pagesize;
        }
        else{
            return -1;
        }
    }
}
