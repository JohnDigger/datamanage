package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.service.InTopThirtyService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.datamanage.datamanage.dao.InFarmScaleDao;
import com.datamanage.datamanage.entity.InFarmScaleEntity;
import com.datamanage.datamanage.service.InFarmScaleService;


@Service("inFarmScaleService")
public class InFarmScaleServiceImpl extends ServiceImpl<InFarmScaleDao, InFarmScaleEntity> implements InFarmScaleService {
    @Autowired
    private InFarmScaleDao inFarmScaleDao;
    @Autowired
    private InTopThirtyService inTopThirtyService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<InFarmScaleEntity> page = this.page(
                new Query<InFarmScaleEntity>().getPage(params),
                new QueryWrapper<InFarmScaleEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<InFarmScaleEntity> getPanel(String address, String date) {
        List<InFarmScaleEntity> list = inFarmScaleDao.getPanel(address, date);
        list.forEach(ele->{
            ele.setTop1Sale(String.valueOf(inTopThirtyService.getTop(address, date)));
        });
        return list;
    }

}