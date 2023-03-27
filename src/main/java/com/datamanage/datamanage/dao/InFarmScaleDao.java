package com.datamanage.datamanage.dao;

import com.datamanage.datamanage.entity.InFarmScaleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datamanage.datamanage.entity.InFarmScaleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2023-03-27 15:12:44
 */
@Mapper
public interface InFarmScaleDao extends BaseMapper<InFarmScaleEntity> {
	@Select("SELECT * FROM in_farm_scale WHERE in_farm_scale.data_address = #{address} AND in_farm_scale.sale_date = #{date} ")
    List<InFarmScaleEntity> getPanel(String address,String date);
}
