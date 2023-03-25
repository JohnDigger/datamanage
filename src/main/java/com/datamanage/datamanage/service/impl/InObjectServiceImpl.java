package com.datamanage.datamanage.service.impl;

import com.datamanage.datamanage.dao.InObjectDao;
import com.datamanage.datamanage.entity.InObjectEntity;
import com.datamanage.datamanage.service.InObjectService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("inObjectService")
public class InObjectServiceImpl extends ServiceImpl<InObjectDao, InObjectEntity> implements InObjectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<InObjectEntity> page = this.page(
                new Query<InObjectEntity>().getPage(params),
                new QueryWrapper<InObjectEntity>()
        );

        return new PageUtils(page);
    }

}