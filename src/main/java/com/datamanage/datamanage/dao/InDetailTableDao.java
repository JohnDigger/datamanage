package com.datamanage.datamanage.dao;

import com.datamanage.datamanage.entity.InDetailTableEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2023-03-26 13:57:16
 */
@Mapper
public interface InDetailTableDao extends BaseMapper<InDetailTableEntity> {
	@Select("SELECT * FROM in_detail_table WHERE in_detail_table.detail_date LIKE '${date}-%' AND in_detail_table.data_address = #{address} AND in_detail_table.type = #{type} ORDER BY in_detail_table.detail_date")
    List<InDetailTableEntity> getTable(String date,String address,String type);
}
