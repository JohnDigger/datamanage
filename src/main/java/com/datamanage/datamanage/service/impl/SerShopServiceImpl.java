package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.SerShopDao;
import com.datamanage.datamanage.entity.NameValueEntity;
import com.datamanage.datamanage.entity.SerShopEntity;
import com.datamanage.datamanage.service.SerShopService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("serShopService")
public class SerShopServiceImpl extends ServiceImpl<SerShopDao, SerShopEntity> implements SerShopService {
    @Autowired
    private SerShopDao serShopDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<SerShopEntity> page = this.page(
                new Query<SerShopEntity>().getPage(params),
                new QueryWrapper<SerShopEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<NameValueEntity> getTopAmount(String data_address, String order_type) {
        return serShopDao.getTopAmount(data_address, order_type);
    }

    @Override
    public List<NameValueEntity> getTopCount(String data_address, String order_type) {
        return serShopDao.getTopCount(data_address, order_type);
    }

}