package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.datamanage.datamanage.dao.SerPanelDao;
import com.datamanage.datamanage.entity.SerPanelEntity;
import com.datamanage.datamanage.service.SerPanelService;


@Service("serPanelService")
public class SerPanelServiceImpl extends ServiceImpl<SerPanelDao, SerPanelEntity> implements SerPanelService {
    @Autowired
    private SerPanelDao serPanelDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<SerPanelEntity> page = this.page(
                new Query<SerPanelEntity>().getPage(params),
                new QueryWrapper<SerPanelEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<SerPanelEntity> getList(String address, String date) {
        return serPanelDao.getList(address, date);
    }

}