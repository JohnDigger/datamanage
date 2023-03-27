package com.datamanage.datamanage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datamanage.datamanage.entity.FpEnterpriseEntity;
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
public interface FpEnterpriseDao extends BaseMapper<FpEnterpriseEntity> {

    @Select("SELECT fp_enterprise.id,fp_enterprise.enterprise_name FROM fp_enterprise WHERE fp_enterprise.data_address = #{dataAddress} LIMIT 20")
    List<FpEnterpriseEntity> getTopTwenty(String dataAddress);
}
