package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.InDetailTableDao;
import com.datamanage.datamanage.entity.InDetailTableEntity;
import com.datamanage.datamanage.service.InDetailTableService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service("inDetailTableService")
public class InDetailTableServiceImpl extends ServiceImpl<InDetailTableDao, InDetailTableEntity> implements InDetailTableService {
    @Autowired
    private InDetailTableDao inDetailTableDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<InDetailTableEntity> page = this.page(
                new Query<InDetailTableEntity>().getPage(params),
                new QueryWrapper<InDetailTableEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<InDetailTableEntity> getTable(String date, String address, String type) {
        return inDetailTableDao.getTable(date, address, type);
    }


}