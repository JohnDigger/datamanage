package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.SerSellHalfYearDao;
import com.datamanage.datamanage.entity.NameValueEntity;
import com.datamanage.datamanage.entity.SerSellHalfYearEntity;
import com.datamanage.datamanage.service.SerSellHalfYearService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("serSellHalfYearService")
public class SerSellHalfYearServiceImpl extends ServiceImpl<SerSellHalfYearDao, SerSellHalfYearEntity> implements SerSellHalfYearService {
    @Autowired
    private SerSellHalfYearDao serSellHalfYearDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<SerSellHalfYearEntity> page = this.page(
                new Query<SerSellHalfYearEntity>().getPage(params),
                new QueryWrapper<SerSellHalfYearEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<NameValueEntity> getHalfYear(String type_data, String order_time) {
        return serSellHalfYearDao.getHalfYear(type_data, order_time);
    }

    @Override
    public List<NameValueEntity> getHaldYearCount(String type_data, String data_address) {
        return serSellHalfYearDao.getHaldYearCount(type_data, data_address);
    }

}