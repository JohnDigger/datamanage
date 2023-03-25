package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.InObjectAnalyseDao;
import com.datamanage.datamanage.entity.InObjectAnalyseEntity;
import com.datamanage.datamanage.service.InObjectAnalyseService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("inObjectAnalyseService")
public class InObjectAnalyseServiceImpl extends ServiceImpl<InObjectAnalyseDao, InObjectAnalyseEntity> implements InObjectAnalyseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<InObjectAnalyseEntity> page = this.page(
                new Query<InObjectAnalyseEntity>().getPage(params),
                new QueryWrapper<InObjectAnalyseEntity>()
        );

        return new PageUtils(page);
    }

}