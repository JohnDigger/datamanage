package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.FrontMonthDao;
import com.datamanage.datamanage.entity.FrontMonthEntity;
import com.datamanage.datamanage.service.FrontMonthService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service("frontMonthService")
public class FrontMonthServiceImpl extends ServiceImpl<FrontMonthDao, FrontMonthEntity> implements FrontMonthService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<FrontMonthEntity> page = this.page(
                new Query<FrontMonthEntity>().getPage(params),
                new QueryWrapper<FrontMonthEntity>()
        );

        return new PageUtils(page);
    }

}