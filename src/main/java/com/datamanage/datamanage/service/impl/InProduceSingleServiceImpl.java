package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.InProduceSingleDao;
import com.datamanage.datamanage.entity.InProduceSingleEntity;
import com.datamanage.datamanage.service.InProduceSingleService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("inProduceSingleService")
public class InProduceSingleServiceImpl extends ServiceImpl<InProduceSingleDao, InProduceSingleEntity> implements InProduceSingleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<InProduceSingleEntity> page = this.page(
                new Query<InProduceSingleEntity>().getPage(params),
                new QueryWrapper<InProduceSingleEntity>()
        );

        return new PageUtils(page);
    }

}