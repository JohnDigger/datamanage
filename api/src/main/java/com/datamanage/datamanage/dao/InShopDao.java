package com.datamanage.datamanage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datamanage.datamanage.entity.InShopEntity;
import org.apache.ibatis.annotations.Insert;
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
public interface InShopDao extends BaseMapper<InShopEntity> {
	@Select("SELECT * FROM in_shop WHERE in_shop.data_address = #{address} ORDER BY in_shop.sale_money")
    List<InShopEntity> getAll(String address);
	@Insert("INSERT INTO in_shop (index, name,belongTo,dataAddress,time) VALUES (#{index}, #{name},#{belongTo},#{dataAddress},#{time}))")
    int insert(InShopEntity inShopEntity);
}
