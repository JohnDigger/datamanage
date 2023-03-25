package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.InProduceCompareDao;
import com.datamanage.datamanage.entity.InProduceCompareEntity;
import com.datamanage.datamanage.service.InProduceCompareService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("inProduceCompareService")
public class InProduceCompareServiceImpl extends ServiceImpl<InProduceCompareDao, InProduceCompareEntity> implements InProduceCompareService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<InProduceCompareEntity> page = this.page(
                new Query<InProduceCompareEntity>().getPage(params),
                new QueryWrapper<InProduceCompareEntity>()
        );

        return new PageUtils(page);
    }

}