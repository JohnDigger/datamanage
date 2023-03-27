package com.datamanage.datamanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.datamanage.datamanage.entity.NameValueEntity;
import com.datamanage.datamanage.entity.SerSellHalfYearEntity;
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
public interface SerSellHalfYearService extends IService<SerSellHalfYearEntity> {

    PageUtils queryPage(Map<String, Object> params) throws Exception;

    List<NameValueEntity> getHalfYear(String type_data, String order_time);

    List<NameValueEntity> getHaldYearCount(String type_data,String data_address);
}

