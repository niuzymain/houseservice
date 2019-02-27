package com.house.service.servicer;

import com.house.entity.Evaluate;
import com.house.entity.Servicer;
import java.util.List;

public interface EvaluateService {
    List<Evaluate> checkEvaluate(Servicer servicer);
}
