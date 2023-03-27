package com.datamanage.datamanage.dao;

import com.datamanage.datamanage.entity.SerPanelEntity;
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
public interface SerPanelDao extends BaseMapper<SerPanelEntity> {
	@Select("SELECT * FROM ser_panel WHERE ser_panel.data_address = #{address} AND ser_panel.data_date = #{date}")
    List<SerPanelEntity> getList(String address,String date);
}
