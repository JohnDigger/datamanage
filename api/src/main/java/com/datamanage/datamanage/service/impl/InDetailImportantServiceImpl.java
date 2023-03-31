package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.datamanage.datamanage.dao.InDetailImportantDao;
import com.datamanage.datamanage.entity.InDetailImportantEntity;
import com.datamanage.datamanage.service.InDetailImportantService;


@Service("inDetailImportantService")
public class InDetailImportantServiceImpl extends ServiceImpl<InDetailImportantDao, InDetailImportantEntity> implements InDetailImportantService {
    @Autowired
    private InDetailImportantDao inDetailImportantDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<InDetailImportantEntity> page = this.page(
                new Query<InDetailImportantEntity>().getPage(params),
                new QueryWrapper<InDetailImportantEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<InDetailImportantEntity> getList(String address, String date, String type) {
        return inDetailImportantDao.getList(address, date, type);
    }

}