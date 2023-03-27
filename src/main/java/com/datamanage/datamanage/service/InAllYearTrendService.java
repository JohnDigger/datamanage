package com.datamanage.datamanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.datamanage.datamanage.entity.InAllYearTrendEntity;
import com.datamanage.datamanage.entity.NameValueEntity;
import com.datamanage.datamanage.utils.PageUtils;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2023-03-26 00:58:52
 */
public interface InAllYearTrendService extends IService<InAllYearTrendEntity> {

    PageUtils queryPage(Map<String, Object> params) throws Exception;
    List<NameValueEntity> getMoney(String data);
    List<NameValueEntity> getCount(String data);
}

