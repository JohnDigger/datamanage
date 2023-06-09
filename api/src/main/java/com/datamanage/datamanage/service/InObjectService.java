package com.datamanage.datamanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.datamanage.datamanage.entity.InObjectEntity;
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
public interface InObjectService extends IService<InObjectEntity> {

    PageUtils queryPage(Map<String, Object> params) throws Exception;
    List<NameValueEntity> getList(String address, String date);
    List<InObjectEntity> getObjList(String address,String date);
    List<InObjectEntity> getTrend(String address,String date);
}

