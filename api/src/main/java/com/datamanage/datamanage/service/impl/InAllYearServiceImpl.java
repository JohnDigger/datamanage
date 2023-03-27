package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.InAllYearDao;
import com.datamanage.datamanage.entity.InAllYearEntity;
import com.datamanage.datamanage.service.InAllYearService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("inAllYearService")
public class InAllYearServiceImpl extends ServiceImpl<InAllYearDao, InAllYearEntity> implements InAllYearService {
    @Autowired
    private InAllYearDao inAllYearDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<InAllYearEntity> page = this.page(
                new Query<InAllYearEntity>().getPage(params),
                new QueryWrapper<InAllYearEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<InAllYearEntity> getData(String address) {
        return inAllYearDao.getData(address);
    }

}