package mybatis.mapper;

import java.util.List;
import mybatis.entity.TbServicer;
import mybatis.entity.TbServicerExample;
import org.apache.ibatis.annotations.Param;

public interface TbServicerMapper {
    long countByExample(TbServicerExample example);

    int deleteByExample(TbServicerExample example);

    int deleteByPrimaryKey(Integer servicerId);

    int insert(TbServicer record);

    int insertSelective(TbServicer record);

    List<TbServicer> selectByExample(TbServicerExample example);

    TbServicer selectByPrimaryKey(Integer servicerId);

    int updateByExampleSelective(@Param("record") TbServicer record, @Param("example") TbServicerExample example);

    int updateByExample(@Param("record") TbServicer record, @Param("example") TbServicerExample example);

    int updateByPrimaryKeySelective(TbServicer record);

    int updateByPrimaryKey(TbServicer record);
}