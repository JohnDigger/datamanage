package com.datamanage.datamanage.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datamanage.datamanage.entity.InFarmProductEntity;
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
public interface InFarmProductDao extends BaseMapper<InFarmProductEntity> {
    @Select("SELECT * \n" +
            "FROM in_farm_product\n" +
            "WHERE farm_address = #{data_address} AND farm_date = #{data_time} order by farm_money DESC")
    List<InFarmProductEntity> getProduct(String data_address,String data_time);
	
}
