package com.datamanage.datamanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.datamanage.datamanage.entity.FpPanelEntity;
import com.datamanage.datamanage.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2023-03-27 15:47:26
 */
public interface FpPanelService extends IService<FpPanelEntity> {

    PageUtils queryPage(Map<String, Object> params) throws Exception;
    List<FpPanelEntity> getList(String address);
}

