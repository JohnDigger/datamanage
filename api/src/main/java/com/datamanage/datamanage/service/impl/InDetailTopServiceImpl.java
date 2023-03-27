package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.InDetailTopDao;
import com.datamanage.datamanage.entity.InDetailTopEntity;
import com.datamanage.datamanage.service.InDetailTopService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("inDetailTopService")
public class InDetailTopServiceImpl extends ServiceImpl<InDetailTopDao, InDetailTopEntity> implements InDetailTopService {
    @Autowired
    private InDetailTopDao inDetailTopDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<InDetailTopEntity> page = this.page(
                new Query<InDetailTopEntity>().getPage(params),
                new QueryWrapper<InDetailTopEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<InDetailTopEntity> getTopTen(String date, String address, String type) {
        return inDetailTopDao.getTopTen(date, address, type);
    }

}