package com.datamanage.datamanage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datamanage.datamanage.entity.FpReasonEntity;
import com.datamanage.datamanage.entity.NameValueEntity;
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
public interface FpReasonDao extends BaseMapper<FpReasonEntity> {
	@Select("SELECT CONCAT(FORMAT(fp_reason.reason_ammount, 2), '%') AS value,fp_reason.reason_name as name FROM fp_reason WHERE fp_reason.data_address = #{fpAddress}")
    List<NameValueEntity> fpReason(String fpAddress);
}
