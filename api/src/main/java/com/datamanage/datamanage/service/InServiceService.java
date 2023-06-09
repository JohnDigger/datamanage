package com.datamanage.datamanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.datamanage.datamanage.entity.InServiceEntity;
import com.datamanage.datamanage.entity.NameValueEntity;
import com.datamanage.datamanage.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2023-03-26 00:58:52
 */
public interface InServiceService extends IService<InServiceEntity> {

    PageUtils queryPage(Map<String, Object> params) throws Exception;
    List<NameValueEntity> getService(String address, String date);
    List<InServiceEntity> getServiceList(String address,String date);
    List<InServiceEntity> getServiceListData(String address,String date);
}

