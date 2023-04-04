package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.datamanage.datamanage.dao.InShopDao;
import com.datamanage.datamanage.entity.InDetailTopEntity;
import com.datamanage.datamanage.entity.InShopEntity;
import com.datamanage.datamanage.service.InShopService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.R;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2023-03-23 20:26:35
 */
@RestController
@RequestMapping("back/inshop")
public class InShopController {
    @Autowired
    private InShopService inShopService;
    private final ObjectMapper objectMapper = new ObjectMapper();
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = inShopService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		InShopEntity inShop = inShopService.getById(id);

        return R.ok().put("inShop", inShop);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody InShopEntity[] inShopEntities){
        Arrays.asList(inShopEntities).forEach(ele->{
            QueryWrapper<InShopEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("shop_time",ele.getShopTime())
                    .eq("shop_index",ele.getShopIndex())
                    .eq("data_address",ele.getDataAddress());
            if (inShopService.list(queryWrapper).size() == 0){
                inShopService.save(ele);
            }else {
                inShopService.update(ele,queryWrapper);
            }
        });
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InShopEntity inShop){
		inShopService.updateById(inShop);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		inShopService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
    @GetMapping("getAll")
    public R shops(@RequestParam("address")String address){
        return R.ok().put("data",inShopService.getAll(address));
    }

    @GetMapping("getList")
    public R shopsList(@RequestParam("address")String address,@RequestParam("date")String date){
        return R.ok().put("data",inShopService.getList(address,date));
    }
}
