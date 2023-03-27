package com.datamanage.datamanage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datamanage.datamanage.entity.NameValueEntity;
import com.datamanage.datamanage.entity.SerTypeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2023-03-23 20:26:35
 */
@Mapper
public interface SerTypeDao extends BaseMapper<SerTypeEntity> {
	@Select("SELECT ser_type.ser_ammount as value,ser_type.ser_type as name FROM ser_type WHERE ser_type.data_address = #{address}")
    List<NameValueEntity> getSerType(String address);
}
