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


import com.datamanage.datamanage.dao.InTopThirtyDao;
import com.datamanage.datamanage.entity.InTopThirtyEntity;
import com.datamanage.datamanage.service.InTopThirtyService;


@Service("inTopThirtyService")
public class InTopThirtyServiceImpl extends ServiceImpl<InTopThirtyDao, InTopThirtyEntity> implements InTopThirtyService {
    @Autowired
    private InTopThirtyDao inTopThirtyDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<InTopThirtyEntity> page = this.page(
                new Query<InTopThirtyEntity>().getPage(params),
                new QueryWrapper<InTopThirtyEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<InTopThirtyEntity> getTopThirty(String address) {
        return inTopThirtyDao.getTopThirty(address);
    }

}