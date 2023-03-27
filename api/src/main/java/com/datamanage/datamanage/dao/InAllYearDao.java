package com.datamanage.datamanage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datamanage.datamanage.entity.InAllYearEntity;
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
public interface InAllYearDao extends BaseMapper<InAllYearEntity> {
	@Select("select year_total_money,year_total_num FROM in_all_year WHERE year_address = #{address}")
    List<InAllYearEntity> getData(String address);
}
