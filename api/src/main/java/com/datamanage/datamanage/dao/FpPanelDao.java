package com.datamanage.datamanage.dao;

import com.datamanage.datamanage.entity.FpPanelEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2023-03-27 15:47:26
 */
@Mapper
public interface FpPanelDao extends BaseMapper<FpPanelEntity> {
	@Select("SELECT * FROM fp_panel WHERE fp_panel.data_address = #{address}")
    List<FpPanelEntity> getList(String address);
}
