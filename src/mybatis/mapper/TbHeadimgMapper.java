package mybatis.mapper;

import java.util.List;
import mybatis.entity.TbHeadimg;
import mybatis.entity.TbHeadimgExample;
import org.apache.ibatis.annotations.Param;

public interface TbHeadimgMapper {
    long countByExample(TbHeadimgExample example);

    int deleteByExample(TbHeadimgExample example);

    int deleteByPrimaryKey(Integer headimgId);

    int insert(TbHeadimg record);

    int insertSelective(TbHeadimg record);

    List<TbHeadimg> selectByExample(TbHeadimgExample example);

    TbHeadimg selectByPrimaryKey(Integer headimgId);

    int updateByExampleSelective(@Param("record") TbHeadimg record, @Param("example") TbHeadimgExample example);

    int updateByExample(@Param("record") TbHeadimg record, @Param("example") TbHeadimgExample example);

    int updateByPrimaryKeySelective(TbHeadimg record);

    int updateByPrimaryKey(TbHeadimg record);
}