package mybatis.mapper;

import java.util.List;
import mybatis.entity.TbSuperadmin;
import mybatis.entity.TbSuperadminExample;
import org.apache.ibatis.annotations.Param;

public interface TbSuperadminMapper {
    long countByExample(TbSuperadminExample example);

    int deleteByExample(TbSuperadminExample example);

    int deleteByPrimaryKey(Integer superadminId);

    int insert(TbSuperadmin record);

    int insertSelective(TbSuperadmin record);

    List<TbSuperadmin> selectByExample(TbSuperadminExample example);

    TbSuperadmin selectByPrimaryKey(Integer superadminId);

    int updateByExampleSelective(@Param("record") TbSuperadmin record, @Param("example") TbSuperadminExample example);

    int updateByExample(@Param("record") TbSuperadmin record, @Param("example") TbSuperadminExample example);

    int updateByPrimaryKeySelective(TbSuperadmin record);

    int updateByPrimaryKey(TbSuperadmin record);
}