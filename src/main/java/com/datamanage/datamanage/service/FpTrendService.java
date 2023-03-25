package com.datamanage.datamanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.datamanage.datamanage.entity.FpTrendEntity;
import com.datamanage.datamanage.entity.NameValueEntity;
import com.datamanage.datamanage.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2023-03-23 20:26:35
 */
public interface FpTrendService extends IService<FpTrendEntity> {

    PageUtils queryPage(Map<String, Object> params) throws Exception;

    List<NameValueEntity> getTrend(String address, String time);
}

