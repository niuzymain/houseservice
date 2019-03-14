package com.house.util;

import com.house.entity.AdminMsg;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortUtil {
    public static void sortMessageList(List<AdminMsg> adminMsgList){
        Collections.sort(adminMsgList, new Comparator<AdminMsg>(){
            /*
             * int compare(Person p1, Person p2) 返回一个基本类型的整型，
             * 返回负数表示：p1 小于p2，
             * 返回0 表示：p1和p2相等，
             * 返回正数表示：p1大于p2
             */
            @Override
            public int compare(AdminMsg o1, AdminMsg o2) {
                if(o1.getCreatetime().getTime() < o2.getCreatetime().getTime()){
                    return 1;
                }
                if(o1.getCreatetime().getTime() == o2.getCreatetime().getTime()){
                    return 0;
                }
                return -1;
            }
        });
    }
}
