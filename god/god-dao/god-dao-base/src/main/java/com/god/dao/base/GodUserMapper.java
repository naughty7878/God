package com.god.dao.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.god.domain.base.GodUser;
import com.god.domain.base.GodUserExample;

public interface GodUserMapper {
    long countByExample(GodUserExample example);

    int deleteByExample(GodUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GodUser record);

    int insertSelective(GodUser record);

    List<GodUser> selectByExample(GodUserExample example);

    GodUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GodUser record, @Param("example") GodUserExample example);

    int updateByExample(@Param("record") GodUser record, @Param("example") GodUserExample example);

    int updateByPrimaryKeySelective(GodUser record);

    int updateByPrimaryKey(GodUser record);
}