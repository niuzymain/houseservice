package mybatis.mapper;

import java.util.List;
import mybatis.entity.TbRecommend;
import mybatis.entity.TbRecommendExample;
import org.apache.ibatis.annotations.Param;

public interface TbRecommendMapper {
    long countByExample(TbRecommendExample example);

    int deleteByExample(TbRecommendExample example);

    int deleteByPrimaryKey(Integer recommendId);

    int insert(TbRecommend record);

    int insertSelective(TbRecommend record);

    List<TbRecommend> selectByExample(TbRecommendExample example);

    TbRecommend selectByPrimaryKey(Integer recommendId);

    int updateByExampleSelective(@Param("record") TbRecommend record, @Param("example") TbRecommendExample example);

    int updateByExample(@Param("record") TbRecommend record, @Param("example") TbRecommendExample example);

    int updateByPrimaryKeySelective(TbRecommend record);

    int updateByPrimaryKey(TbRecommend record);
}