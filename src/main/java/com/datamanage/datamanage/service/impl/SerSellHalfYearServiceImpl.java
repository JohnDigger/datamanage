package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.SerSellHalfYearDao;
import com.datamanage.datamanage.entity.SerSellHalfYearEntity;
import com.datamanage.datamanage.service.SerSellHalfYearService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("serSellHalfYearService")
public class SerSellHalfYearServiceImpl extends ServiceImpl<SerSellHalfYearDao, SerSellHalfYearEntity> implements SerSellHalfYearService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<SerSellHalfYearEntity> page = this.page(
                new Query<SerSellHalfYearEntity>().getPage(params),
                new QueryWrapper<SerSellHalfYearEntity>()
        );

        return new PageUtils(page);
    }

}