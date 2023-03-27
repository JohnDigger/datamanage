package com.datamanage.datamanage.dao;

import com.datamanage.datamanage.entity.InDetailPanelEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2023-03-26 13:57:16
 */
@Mapper
public interface InDetailPanelDao extends BaseMapper<InDetailPanelEntity> {
	@Select("SELECT\n" +
            "\tin_detail_panel.detail_count, \n" +
            "\tin_detail_panel.detail_money\n" +
            "FROM\n" +
            "\tin_detail_panel\n" +
            "WHERE\n" +
            "\tin_detail_panel.data_date = #{date} AND\n" +
            "\tin_detail_panel.data_address = #{address} AND\n" +
            "\tin_detail_panel.type = #{type}")
    List<InDetailPanelEntity> getPanel(String address,String date,String type);
}
