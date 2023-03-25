package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.FpPanelDao;
import com.datamanage.datamanage.entity.FpPanelEntity;
import com.datamanage.datamanage.service.FpPanelService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("fpPanelService")
public class FpPanelServiceImpl extends ServiceImpl<FpPanelDao, FpPanelEntity> implements FpPanelService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<FpPanelEntity> page = this.page(
                new Query<FpPanelEntity>().getPage(params),
                new QueryWrapper<FpPanelEntity>()
        );

        return new PageUtils(page);
    }

}