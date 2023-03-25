package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.InProduceDao;
import com.datamanage.datamanage.entity.InProduceEntity;
import com.datamanage.datamanage.service.InProduceService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("inProduceService")
public class InProduceServiceImpl extends ServiceImpl<InProduceDao, InProduceEntity> implements InProduceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<InProduceEntity> page = this.page(
                new Query<InProduceEntity>().getPage(params),
                new QueryWrapper<InProduceEntity>()
        );

        return new PageUtils(page);
    }

}