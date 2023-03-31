package com.datamanage.datamanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.datamanage.datamanage.entity.InDetailImportantEntity;
import com.datamanage.datamanage.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2023-03-31 16:15:20
 */
public interface InDetailImportantService extends IService<InDetailImportantEntity> {

    PageUtils queryPage(Map<String, Object> params) throws Exception;
    List<InDetailImportantEntity> getList(String address, String date, String type);
}

