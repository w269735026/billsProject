package com.wwl.mapper;

import com.wwl.pojo.Describes;
import com.wwl.pojo.DescribesExample;
import com.wwl.pojo.DescribesWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DescribesMapper {
    int countByExample(DescribesExample example);

    int deleteByExample(DescribesExample example);
  //改动过
    int deleteByPrimaryKey(Integer billsid);

    //改动过
    int insert(Describes describes);

    int insertSelective(DescribesWithBLOBs record);

    List<DescribesWithBLOBs> selectByExampleWithBLOBs(DescribesExample example);

    List<Describes> selectByExample(DescribesExample example);

    DescribesWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(Describes describes);

    int updateByExampleWithBLOBs(@Param("record") DescribesWithBLOBs record, @Param("example") DescribesExample example);

    int updateByExample(@Param("record") Describes record, @Param("example") DescribesExample example);

    int updateByPrimaryKeySelective(Describes describes);

    int updateByPrimaryKeyWithBLOBs(DescribesWithBLOBs record);

    int updateByPrimaryKey(Describes record);
}