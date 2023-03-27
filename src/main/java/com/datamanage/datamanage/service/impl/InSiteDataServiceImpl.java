package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.InSiteDataDao;
import com.datamanage.datamanage.entity.InSiteDataEntity;
import com.datamanage.datamanage.service.InSiteDataService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("inSiteDataService")
public class InSiteDataServiceImpl extends ServiceImpl<InSiteDataDao, InSiteDataEntity> implements InSiteDataService {
    @Autowired
    private InSiteDataDao inSiteDataDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<InSiteDataEntity> page = this.page(
                new Query<InSiteDataEntity>().getPage(params),
                new QueryWrapper<InSiteDataEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<InSiteDataEntity> getSite(String address) {
        return inSiteDataDao.getSite(address);
    }

}