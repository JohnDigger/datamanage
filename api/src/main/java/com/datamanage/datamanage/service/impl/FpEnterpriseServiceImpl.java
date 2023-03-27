package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.FpEnterpriseDao;
import com.datamanage.datamanage.entity.FpEnterpriseEntity;
import com.datamanage.datamanage.service.FpEnterpriseService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("fpEnterpriseService")
public class FpEnterpriseServiceImpl extends ServiceImpl<FpEnterpriseDao, FpEnterpriseEntity> implements FpEnterpriseService {
    @Autowired
    private FpEnterpriseDao fpEnterpriseDao;


    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<FpEnterpriseEntity> page = this.page(
                new Query<FpEnterpriseEntity>().getPage(params),
                new QueryWrapper<FpEnterpriseEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<FpEnterpriseEntity> getTopTwenty(String dataAddress) {
        return fpEnterpriseDao.getTopTwenty(dataAddress);
    }

}