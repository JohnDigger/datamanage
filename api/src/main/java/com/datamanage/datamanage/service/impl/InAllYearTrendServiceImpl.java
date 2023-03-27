package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.InAllYearTrendDao;
import com.datamanage.datamanage.entity.InAllYearTrendEntity;
import com.datamanage.datamanage.entity.NameValueEntity;
import com.datamanage.datamanage.service.InAllYearTrendService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("inAllYearTrendService")
public class InAllYearTrendServiceImpl extends ServiceImpl<InAllYearTrendDao, InAllYearTrendEntity> implements InAllYearTrendService {
    @Autowired
    private InAllYearTrendDao inAllYearTrendDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<InAllYearTrendEntity> page = this.page(
                new Query<InAllYearTrendEntity>().getPage(params),
                new QueryWrapper<InAllYearTrendEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<NameValueEntity> getMoney(String data) {
        return inAllYearTrendDao.getMoney(data);
    }

    @Override
    public List<NameValueEntity> getCount(String data) {
        return inAllYearTrendDao.getCount(data);
    }

}