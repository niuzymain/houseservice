package mybatis.mapper;

import java.util.List;
import mybatis.entity.TbAdminmsg;
import mybatis.entity.TbAdminmsgExample;
import org.apache.ibatis.annotations.Param;

public interface TbAdminmsgMapper {
    long countByExample(TbAdminmsgExample example);

    int deleteByExample(TbAdminmsgExample example);

    int deleteByPrimaryKey(Integer adminmsgId);

    int insert(TbAdminmsg record);

    int insertSelective(TbAdminmsg record);

    List<TbAdminmsg> selectByExample(TbAdminmsgExample example);

    TbAdminmsg selectByPrimaryKey(Integer adminmsgId);

    int updateByExampleSelective(@Param("record") TbAdminmsg record, @Param("example") TbAdminmsgExample example);

    int updateByExample(@Param("record") TbAdminmsg record, @Param("example") TbAdminmsgExample example);

    int updateByPrimaryKeySelective(TbAdminmsg record);

    int updateByPrimaryKey(TbAdminmsg record);
}