package com.datamanage.datamanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.datamanage.datamanage.entity.InFarmScaleEntity;
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
public interface InFarmScaleService extends IService<InFarmScaleEntity> {

    PageUtils queryPage(Map<String, Object> params) throws Exception;

    List<InFarmScaleEntity> getPanel(String address, String date);
}

