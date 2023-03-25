package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.SerOrderListDao;
import com.datamanage.datamanage.entity.SerOrderListEntity;
import com.datamanage.datamanage.service.SerOrderListService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("serOrderListService")
public class SerOrderListServiceImpl extends ServiceImpl<SerOrderListDao, SerOrderListEntity> implements SerOrderListService {
    @Autowired
    private SerOrderListDao serOrderListDao;


    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<SerOrderListEntity> page = this.page(
                new Query<SerOrderListEntity>().getPage(params),
                new QueryWrapper<SerOrderListEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<SerOrderListEntity> getRank(String data_address, String data_date) {
        return serOrderListDao.getRank(data_address,data_date);
    }

}