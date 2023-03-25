package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.SerTypeDao;
import com.datamanage.datamanage.entity.SerTypeEntity;
import com.datamanage.datamanage.service.SerTypeService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("serTypeService")
public class SerTypeServiceImpl extends ServiceImpl<SerTypeDao, SerTypeEntity> implements SerTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<SerTypeEntity> page = this.page(
                new Query<SerTypeEntity>().getPage(params),
                new QueryWrapper<SerTypeEntity>()
        );

        return new PageUtils(page);
    }

}