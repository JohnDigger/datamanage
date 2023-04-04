package com.datamanage.datamanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.datamanage.datamanage.entity.InShopEntity;
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
public interface InShopService extends IService<InShopEntity> {

    PageUtils queryPage(Map<String, Object> params) throws Exception;

    List<InShopEntity> getAll(String address);

    List<InShopEntity> getList(String address,String date);
}

