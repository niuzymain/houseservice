package mybatis.mapper;

import java.util.List;
import mybatis.entity.TbEvaluate;
import mybatis.entity.TbEvaluateExample;
import org.apache.ibatis.annotations.Param;

public interface TbEvaluateMapper {
    long countByExample(TbEvaluateExample example);

    int deleteByExample(TbEvaluateExample example);

    int deleteByPrimaryKey(Integer evaluateId);

    int insert(TbEvaluate record);

    int insertSelective(TbEvaluate record);

    List<TbEvaluate> selectByExample(TbEvaluateExample example);

    TbEvaluate selectByPrimaryKey(Integer evaluateId);

    int updateByExampleSelective(@Param("record") TbEvaluate record, @Param("example") TbEvaluateExample example);

    int updateByExample(@Param("record") TbEvaluate record, @Param("example") TbEvaluateExample example);

    int updateByPrimaryKeySelective(TbEvaluate record);

    int updateByPrimaryKey(TbEvaluate record);
}