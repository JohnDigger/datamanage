package com.datamanage.datamanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.datamanage.datamanage.entity.InDetailTopEntity;
import com.datamanage.datamanage.utils.PageUtils;


import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2023-03-26 13:57:16
 */
public interface InDetailTopService extends IService<InDetailTopEntity> {

    PageUtils queryPage(Map<String, Object> params) throws Exception;
    List<InDetailTopEntity> getTopTen(String date, String address, String type);
}

