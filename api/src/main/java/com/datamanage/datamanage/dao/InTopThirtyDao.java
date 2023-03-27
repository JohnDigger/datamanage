package com.datamanage.datamanage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datamanage.datamanage.entity.InTopThirtyEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2023-03-27 15:12:44
 */
@Mapper
public interface InTopThirtyDao extends BaseMapper<InTopThirtyEntity> {
	@Select("select * FROM in_top_thirty WHERE in_top_thirty.data_address = #{address} ORDER BY in_top_thirty.sale_money DESC LIMIT 30")
    List<InTopThirtyEntity> getTopThirty(String address);
}
