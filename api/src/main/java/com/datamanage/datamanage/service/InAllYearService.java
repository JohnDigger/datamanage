package com.datamanage.datamanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.datamanage.datamanage.entity.InAllYearEntity;
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
public interface InAllYearService extends IService<InAllYearEntity> {

    PageUtils queryPage(Map<String, Object> params) throws Exception;
    List<InAllYearEntity> getData(String address);
}

