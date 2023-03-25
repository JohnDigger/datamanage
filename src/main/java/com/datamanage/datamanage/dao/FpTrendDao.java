package com.datamanage.datamanage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datamanage.datamanage.entity.FpTrendEntity;
import com.datamanage.datamanage.entity.NameValueEntity;
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
public interface FpTrendDao extends BaseMapper<FpTrendEntity> {

    @Select("SELECT fp_trend.change_ammount as value, fp_trend.change_date as name \n" +
            "FROM fp_trend \n" +
            "WHERE fp_trend.data_address = #{data_address} AND YEAR(fp_trend.change_date) = #{data_time} \n" +
            "GROUP BY fp_trend.data_address, fp_trend.change_date ORDER BY fp_trend.change_date ")
    List<NameValueEntity> getTrend(String data_address, String data_time);
	
}
