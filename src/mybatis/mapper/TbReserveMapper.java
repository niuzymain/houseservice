package mybatis.mapper;

import java.util.List;
import mybatis.entity.TbReserve;
import mybatis.entity.TbReserveExample;
import org.apache.ibatis.annotations.Param;

public interface TbReserveMapper {
    long countByExample(TbReserveExample example);

    int deleteByExample(TbReserveExample example);

    int deleteByPrimaryKey(Integer reserveId);

    int insert(TbReserve record);

    int insertSelective(TbReserve record);

    List<TbReserve> selectByExample(TbReserveExample example);

    TbReserve selectByPrimaryKey(Integer reserveId);

    int updateByExampleSelective(@Param("record") TbReserve record, @Param("example") TbReserveExample example);

    int updateByExample(@Param("record") TbReserve record, @Param("example") TbReserveExample example);

    int updateByPrimaryKeySelective(TbReserve record);

    int updateByPrimaryKey(TbReserve record);
}