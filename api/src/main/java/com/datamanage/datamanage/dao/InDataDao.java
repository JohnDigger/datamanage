package com.datamanage.datamanage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datamanage.datamanage.entity.InDataEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

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
	@Select("SELECT * FROM in_data\n" +
            "WHERE STR_TO_DATE(CONCAT(in_data.time, '-01'), '%Y-%m-%d') >= STR_TO_DATE(CONCAT(#{year},'-01-01'), '%Y-%m-%d')\n" +
            "AND STR_TO_DATE(CONCAT(in_data.time, '-01'), '%Y-%m-%d') < STR_TO_DATE(CONCAT(#{year},'-',#{month},'-30'), '%Y-%m-%d')" +
            "\tAND in_data.data_address = #{address};")
    List<InDataEntity> getList(String year,String month,String address);

	@Select("SELECT CAST(SUM(total_sale_money) AS CHAR) AS money,CAST(SUM(total_sale_num) AS CHAR) AS num FROM in_data")
    Map<String,String> getAll();
}
