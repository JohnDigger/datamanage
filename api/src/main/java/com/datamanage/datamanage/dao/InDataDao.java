package com.datamanage.datamanage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datamanage.datamanage.entity.InDataEntity;
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
public interface InDataDao extends BaseMapper<InDataEntity> {
	@Select("SELECT * FROM in_data WHERE in_data.data_address = #{address} AND in_data.time = #{dateTime}")
    List<InDataEntity> getPanel(String address,String dateTime);
}
