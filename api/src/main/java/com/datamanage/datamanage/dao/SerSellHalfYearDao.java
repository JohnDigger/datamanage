package com.datamanage.datamanage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datamanage.datamanage.entity.NameValueEntity;
import com.datamanage.datamanage.entity.SerSellHalfYearEntity;
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
public interface SerSellHalfYearDao extends BaseMapper<SerSellHalfYearEntity> {


    @Select("SELECT DATE_FORMAT(order_time, '%Y-%m') AS name, SUM(order_ammount) AS value\n" +
            "FROM ser_sell_half_year\n" +
            "WHERE order_time >= DATE_SUB(NOW(), INTERVAL 6 MONTH) \n" +
            "AND type = #{type_data}\n" +
            "AND data_address = #{city_data}\n" +
            "GROUP BY DATE_FORMAT(order_time, '%Y-%m')\n")
    List<NameValueEntity> getHalfYear(String type_data,String city_data);

    @Select("SELECT DATE_FORMAT(order_time, '%Y-%m') AS name, ROUND(SUM(order_count), 2) as value \n" +
            "FROM ser_sell_half_year\n" +
            "WHERE order_time >= DATE_SUB(NOW(), INTERVAL 6 MONTH) \n" +
            "AND type = #{type_data}\n" +
            "AND data_address = #{data_address}\n" +
            "GROUP BY DATE_FORMAT(order_time, '%Y-%m')\n")
    List<NameValueEntity> getHaldYearCount(String type_data,String data_address);
}
