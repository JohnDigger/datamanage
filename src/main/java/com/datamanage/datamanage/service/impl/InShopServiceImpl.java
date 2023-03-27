package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.InShopDao;
import com.datamanage.datamanage.entity.InShopEntity;
import com.datamanage.datamanage.service.InShopService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("inShopService")
public class InShopServiceImpl extends ServiceImpl<InShopDao, InShopEntity> implements InShopService {
    @Autowired
    private InShopDao inShopDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<InShopEntity> page = this.page(
                new Query<InShopEntity>().getPage(params),
                new QueryWrapper<InShopEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<InShopEntity> getAll(String address) {
        return inShopDao.getAll(address);
    }

}