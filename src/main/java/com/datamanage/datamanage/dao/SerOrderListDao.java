package com.datamanage.datamanage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datamanage.datamanage.entity.SerOrderListEntity;
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
public interface SerOrderListDao extends BaseMapper<SerOrderListEntity> {

    @Select("SELECT ser_order_list.ser_order_ammount,ser_order_list.ser_order_type,ser_order_list.ser_order_num,ser_order_list.ser_order_name\n" +
            "FROM ser_order_list \n" +
            "WHERE ser_order_list.data_address  = #{data_address} AND DATE_FORMAT(ser_order_list.ser_order_date, '%Y-%m') = #{data_date}\n" +
            "GROUP BY ser_order_list.data_address,DATE_FORMAT(ser_order_list.ser_order_date, '%Y-%m')" +
            "ORDER BY ser_order_list.ser_order_ammount")
    List<SerOrderListEntity> getRank(String data_address,String data_date);
	
}
