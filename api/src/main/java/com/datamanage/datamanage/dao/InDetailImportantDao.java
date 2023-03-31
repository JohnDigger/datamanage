package com.datamanage.datamanage.dao;

import com.datamanage.datamanage.entity.InDetailImportantEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2023-03-31 16:15:20
 */
@Mapper
public interface InDetailImportantDao extends BaseMapper<InDetailImportantEntity> {
	@Select("select * from in_detail_important where data_address = #{address} and data_date = #{date} and type = #{type}")
    List<InDetailImportantEntity> getList(String address,String date,String type);
}
