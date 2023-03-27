package com.datamanage.datamanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.datamanage.datamanage.entity.FrontMonthEntity;
import com.datamanage.datamanage.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2023-03-24 09:57:09
 */
public interface FrontMonthService extends IService<FrontMonthEntity> {

    PageUtils queryPage(Map<String, Object> params) throws Exception;
}

