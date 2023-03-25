package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.InServiceAnalyseDao;
import com.datamanage.datamanage.entity.InServiceAnalyseEntity;
import com.datamanage.datamanage.service.InServiceAnalyseService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("inServiceAnalyseService")
public class InServiceAnalyseServiceImpl extends ServiceImpl<InServiceAnalyseDao, InServiceAnalyseEntity> implements InServiceAnalyseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<InServiceAnalyseEntity> page = this.page(
                new Query<InServiceAnalyseEntity>().getPage(params),
                new QueryWrapper<InServiceAnalyseEntity>()
        );

        return new PageUtils(page);
    }

}