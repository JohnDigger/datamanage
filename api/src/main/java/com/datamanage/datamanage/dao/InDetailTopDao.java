package com.datamanage.datamanage.dao;

import com.datamanage.datamanage.entity.InDetailTopEntity;
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
public interface InDetailTopDao extends BaseMapper<InDetailTopEntity> {
	@Select("SELECT\n" +
            "\t*\n" +
            "FROM\n" +
            "\tin_detail_top\n" +
            "WHERE\n" +
            "\tin_detail_top.data_date = #{date} AND\n" +
            "\tin_detail_top.data_address = #{address} AND\n" +
            "\tin_detail_top.type = #{type}\n" +
            "ORDER BY in_detail_top.detail_money\n" +
            "LIMIT 10")
    List<InDetailTopEntity> getTopTen(String date,String address,String type);

    @Select("SELECT\n" +
            "\t*\n" +
            "FROM\n" +
            "\tin_detail_top\n" +
            "WHERE\n" +
            "\tin_detail_top.data_date = #{date} AND\n" +
            "\tin_detail_top.data_address = #{address} AND\n" +
            "\tin_detail_top.type = #{type}\n" +
            "ORDER BY in_detail_top.detail_num\n" +
            "LIMIT 10")
    List<InDetailTopEntity> getTopTenOrder(String date,String address,String type);
}
