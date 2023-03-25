package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.SerShopDao;
import com.datamanage.datamanage.entity.SerShopEntity;
import com.datamanage.datamanage.service.SerShopService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("serShopService")
public class SerShopServiceImpl extends ServiceImpl<SerShopDao, SerShopEntity> implements SerShopService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<SerShopEntity> page = this.page(
                new Query<SerShopEntity>().getPage(params),
                new QueryWrapper<SerShopEntity>()
        );

        return new PageUtils(page);
    }

}