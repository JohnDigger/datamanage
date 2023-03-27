package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.InFarmProductDao;
import com.datamanage.datamanage.entity.InFarmProductEntity;
import com.datamanage.datamanage.service.InFarmProductService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service("inFarmProductService")
public class InFarmProductServiceImpl extends ServiceImpl<InFarmProductDao, InFarmProductEntity> implements InFarmProductService {
    @Autowired
    private InFarmProductDao farmProductDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<InFarmProductEntity> page = this.page(
                new Query<InFarmProductEntity>().getPage(params),
                new QueryWrapper<InFarmProductEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<InFarmProductEntity> getProduct(String data_address, String data_time) {
        return farmProductDao.getProduct(data_address, data_time);
    }

}