package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.FrontAddressDao;
import com.datamanage.datamanage.entity.FrontAddressEntity;
import com.datamanage.datamanage.service.FrontAddressService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("frontAddressService")
public class FrontAddressServiceImpl extends ServiceImpl<FrontAddressDao, FrontAddressEntity> implements FrontAddressService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<FrontAddressEntity> page = this.page(
                new Query<FrontAddressEntity>().getPage(params),
                new QueryWrapper<FrontAddressEntity>()
        );

        return new PageUtils(page);
    }

}