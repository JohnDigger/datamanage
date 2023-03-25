package com.datamanage.datamanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.datamanage.datamanage.entity.InProduceCompareEntity;
import com.datamanage.datamanage.utils.PageUtils;


import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2023-03-23 20:26:35
 */
public interface InProduceCompareService extends IService<InProduceCompareEntity> {

    PageUtils queryPage(Map<String, Object> params) throws Exception;
}

