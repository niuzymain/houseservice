package com.house.service.user;

import com.house.dto.HeadimgExecution;

public interface FrontHeadimgService {
    HeadimgExecution checkHeadimg();
    HeadimgExecution checkSpecificHeadimg(long headimgid);
}
