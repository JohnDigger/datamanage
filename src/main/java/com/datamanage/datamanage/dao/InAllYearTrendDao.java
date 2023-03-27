package com.datamanage.datamanage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datamanage.datamanage.entity.InAllYearTrendEntity;
import com.datamanage.datamanage.entity.NameValueEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
public interface InAllYearTrendDao extends BaseMapper<InAllYearTrendEntity> {
	@Select("SELECT year_money as value,date_time as name\n" +
            "FROM in_all_year_trend\n" +
            "WHERE date_time LIKE '${data}-%'\n" +
            "ORDER BY date_time")
    List<NameValueEntity> getMoney(@Param("data") String data);
    @Select("SELECT year_count as value,date_time as name\n" +
            "FROM in_all_year_trend\n" +
            "WHERE date_time LIKE '${data}-%'\n" +
            "ORDER BY date_time")
    List<NameValueEntity> getCount(@Param("data") String data);
}
