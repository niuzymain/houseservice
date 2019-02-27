package com.house.service.imps.servicer;

import com.house.dao.EvaluateDao;
import com.house.entity.Evaluate;
import com.house.entity.Servicer;
import com.house.service.servicer.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EvaluateServiceImp implements EvaluateService {
    @Autowired
    private EvaluateDao evaluateDao;

    @Override
    public List<Evaluate> checkEvaluate(Servicer servicer) {
        try{
            Evaluate evaluate = new Evaluate();
            evaluate.setServicer(servicer);
            return evaluateDao.queryEvaluate(evaluate);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
}
