package mybatis.mapper;

import java.util.List;
import mybatis.entity.TbWorkarea;
import mybatis.entity.TbWorkareaExample;
import org.apache.ibatis.annotations.Param;

public interface TbWorkareaMapper {
    long countByExample(TbWorkareaExample example);

    int deleteByExample(TbWorkareaExample example);

    int deleteByPrimaryKey(Integer workareaId);

    int insert(TbWorkarea record);

    int insertSelective(TbWorkarea record);

    List<TbWorkarea> selectByExample(TbWorkareaExample example);

    TbWorkarea selectByPrimaryKey(Integer workareaId);

    int updateByExampleSelective(@Param("record") TbWorkarea record, @Param("example") TbWorkareaExample example);

    int updateByExample(@Param("record") TbWorkarea record, @Param("example") TbWorkareaExample example);

    int updateByPrimaryKeySelective(TbWorkarea record);

    int updateByPrimaryKey(TbWorkarea record);
}