package com.datamanage.datamanage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datamanage.datamanage.entity.NameValueEntity;
import com.datamanage.datamanage.entity.SerShopEntity;
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
public interface SerShopDao extends BaseMapper<SerShopEntity> {
    @Select("SELECT \n" +
            "    shop_name as name, \n" +
            "    order_ammount as value \n" +
            "FROM \n" +
            "    ser_shop\n" +
            "WHERE \n" +
            "    data_address = #{data_address} AND order_type = #{order_type}\n" +
            "GROUP BY \n" +
            "    shop_name\n" +
            "ORDER BY \n" +
            "    order_ammount DESC\n" +
            "LIMIT 5;")
    List<NameValueEntity> getTopAmount(String data_address,String order_type);

    @Select("SELECT \n" +
            "    shop_name as name, \n" +
            "    order_count as value \n" +
            "FROM \n" +
            "    ser_shop\n" +
            "WHERE \n" +
            "    data_address = #{data_address} AND order_type = #{order_type}\n" +
            "GROUP BY \n" +
            "    shop_name\n" +
            "ORDER BY \n" +
            "    order_ammount DESC\n" +
            "LIMIT 5;")
    List<NameValueEntity> getTopCount(String data_address,String order_type);
	
}
