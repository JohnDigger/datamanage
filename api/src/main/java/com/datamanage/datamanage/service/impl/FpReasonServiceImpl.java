package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.FpReasonDao;
import com.datamanage.datamanage.entity.FpReasonEntity;
import com.datamanage.datamanage.entity.NameValueEntity;
import com.datamanage.datamanage.service.FpReasonService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("fpReasonService")
public class FpReasonServiceImpl extends ServiceImpl<FpReasonDao, FpReasonEntity> implements FpReasonService {
    @Autowired
    private FpReasonDao reasonDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<FpReasonEntity> page = this.page(
                new Query<FpReasonEntity>().getPage(params),
                new QueryWrapper<FpReasonEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<NameValueEntity> fpReason(String fpAddress) {
        return reasonDao.fpReason(fpAddress);
    }

}