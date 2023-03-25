package com.datamanage.datamanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.datamanage.datamanage.entity.FrontAddressEntity;
import com.datamanage.datamanage.utils.PageUtils;


import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2023-03-24 15:02:27
 */
public interface FrontAddressService extends IService<FrontAddressEntity> {

    PageUtils queryPage(Map<String, Object> params) throws Exception;
}

