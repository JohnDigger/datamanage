package com.datamanage.datamanage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datamanage.datamanage.entity.InSiteDataEntity;
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
public interface InSiteDataDao extends BaseMapper<InSiteDataEntity> {
	@Select("select * FROM in_site_data WHERE data_address = #{address}")
    List<InSiteDataEntity> getSite(String address);
}
