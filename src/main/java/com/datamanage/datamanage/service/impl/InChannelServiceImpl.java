package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.InChannelDao;
import com.datamanage.datamanage.entity.InChannelEntity;
import com.datamanage.datamanage.entity.NameValueEntity;
import com.datamanage.datamanage.service.InChannelService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("inChannelService")
public class InChannelServiceImpl extends ServiceImpl<InChannelDao, InChannelEntity> implements InChannelService {
    @Autowired
    private InChannelDao inChannelDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<InChannelEntity> page = this.page(
                new Query<InChannelEntity>().getPage(params),
                new QueryWrapper<InChannelEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<NameValueEntity> getChannel(String address, String date, String type) {
        return inChannelDao.getChannel(address, date, type);
    }

}