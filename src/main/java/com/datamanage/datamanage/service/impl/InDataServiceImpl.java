package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.InDataDao;
import com.datamanage.datamanage.entity.InDataEntity;
import com.datamanage.datamanage.service.InDataService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("inDataService")
public class InDataServiceImpl extends ServiceImpl<InDataDao, InDataEntity> implements InDataService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<InDataEntity> page = this.page(
                new Query<InDataEntity>().getPage(params),
                new QueryWrapper<InDataEntity>()
        );

        return new PageUtils(page);
    }

}