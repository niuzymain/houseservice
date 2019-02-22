package mybatis.mapper;

import java.util.List;
import mybatis.entity.TbDegree;
import mybatis.entity.TbDegreeExample;
import org.apache.ibatis.annotations.Param;

public interface TbDegreeMapper {
    long countByExample(TbDegreeExample example);

    int deleteByExample(TbDegreeExample example);

    int deleteByPrimaryKey(Integer degreeId);

    int insert(TbDegree record);

    int insertSelective(TbDegree record);

    List<TbDegree> selectByExample(TbDegreeExample example);

    TbDegree selectByPrimaryKey(Integer degreeId);

    int updateByExampleSelective(@Param("record") TbDegree record, @Param("example") TbDegreeExample example);

    int updateByExample(@Param("record") TbDegree record, @Param("example") TbDegreeExample example);

    int updateByPrimaryKeySelective(TbDegree record);

    int updateByPrimaryKey(TbDegree record);
}