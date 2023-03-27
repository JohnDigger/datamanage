package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.InDetailPanelDao;
import com.datamanage.datamanage.entity.InDetailPanelEntity;
import com.datamanage.datamanage.service.InDetailPanelService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("inDetailPanelService")
public class InDetailPanelServiceImpl extends ServiceImpl<InDetailPanelDao, InDetailPanelEntity> implements InDetailPanelService {
    @Autowired
    private InDetailPanelDao inDetailPanelDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<InDetailPanelEntity> page = this.page(
                new Query<InDetailPanelEntity>().getPage(params),
                new QueryWrapper<InDetailPanelEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<InDetailPanelEntity> getPanel(String address, String date, String type) {
        return inDetailPanelDao.getPanel(address, date, type);
    }

}