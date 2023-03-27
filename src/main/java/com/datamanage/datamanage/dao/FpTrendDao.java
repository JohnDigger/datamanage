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

    @Select("SELECT fp_trend.change_date AS name,Sum(fp_trend.change_ammount) AS value\n" +
            "FROM fp_trend\n" +
            "WHERE fp_trend.data_address = #{data_address} \n" +
            "GROUP BY fp_trend.change_date\n" +
            "\n")
    List<NameValueEntity> getTrend(String data_address);
	
}
