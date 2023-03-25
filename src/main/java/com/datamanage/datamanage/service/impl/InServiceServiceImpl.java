package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.InServiceDao;
import com.datamanage.datamanage.entity.InServiceEntity;
import com.datamanage.datamanage.service.InServiceService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("inServiceService")
public class InServiceServiceImpl extends ServiceImpl<InServiceDao, InServiceEntity> implements InServiceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<InServiceEntity> page = this.page(
                new Query<InServiceEntity>().getPage(params),
                new QueryWrapper<InServiceEntity>()
        );

        return new PageUtils(page);
    }

}