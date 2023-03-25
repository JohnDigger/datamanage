package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.FpTrendDao;
import com.datamanage.datamanage.entity.FpTrendEntity;
import com.datamanage.datamanage.entity.NameValueEntity;
import com.datamanage.datamanage.service.FpTrendService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("fpTrendService")
public class FpTrendServiceImpl extends ServiceImpl<FpTrendDao, FpTrendEntity> implements FpTrendService {

    @Autowired
    private FpTrendDao fpTrendDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<FpTrendEntity> page = this.page(
                new Query<FpTrendEntity>().getPage(params),
                new QueryWrapper<FpTrendEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<NameValueEntity> getTrend(String address, String time) {
        return fpTrendDao.getTrend(address, time);
    }

}