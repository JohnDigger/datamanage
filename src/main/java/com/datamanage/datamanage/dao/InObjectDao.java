package com.datamanage.datamanage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datamanage.datamanage.entity.InObjectEntity;
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
public interface InObjectDao extends BaseMapper<InObjectEntity> {
	@Select("SELECT in_object.object_name AS name,in_object.object_percent AS value\n" +
            "FROM in_object\n" +
            "WHERE in_object.object_address = #{address} AND in_object.object_date = #{date} \n")
    List<NameValueEntity> getList(String address,String date);
}
