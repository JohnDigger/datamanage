package com.datamanage.datamanage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datamanage.datamanage.entity.InServiceEntity;
import com.datamanage.datamanage.entity.NameValueEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2023-03-26 00:58:52
 */
@Mapper
public interface InServiceDao extends BaseMapper<InServiceEntity> {
    @Select("SELECT in_service.service_name as name,in_service.service_percent AS value\n" +
            "FROM in_service WHERE in_service.service_address = #{address} AND in_service.service_date = #{date}")
    List<NameValueEntity> getService(String address,String date);
	
}
