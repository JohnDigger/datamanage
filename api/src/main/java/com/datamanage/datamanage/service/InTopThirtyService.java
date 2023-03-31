package com.datamanage.datamanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.datamanage.datamanage.entity.InTopThirtyEntity;
import com.datamanage.datamanage.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2023-03-27 15:12:44
 */
public interface InTopThirtyService extends IService<InTopThirtyEntity> {

    PageUtils queryPage(Map<String, Object> params) throws Exception;
    List<InTopThirtyEntity> getTopThirty(String address,String date_time);
    Integer getTop(String address,String data_date);
    List<InTopThirtyEntity> getTopThirtyOrder(String address,String date_time);
}

