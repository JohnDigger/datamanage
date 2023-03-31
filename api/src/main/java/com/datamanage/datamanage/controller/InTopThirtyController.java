package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.datamanage.datamanage.entity.InDetailTopEntity;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.datamanage.datamanage.entity.InTopThirtyEntity;
import com.datamanage.datamanage.service.InTopThirtyService;




/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2023-03-27 15:12:44
 */
@RestController
@RequestMapping("back/intopthirty")
public class InTopThirtyController {
    @Autowired
    private InTopThirtyService inTopThirtyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = inTopThirtyService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		InTopThirtyEntity inTopThirty = inTopThirtyService.getById(id);

        return R.ok().put("inTopThirty", inTopThirty);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody InTopThirtyEntity[] inTopThirty){
        Arrays.asList(inTopThirty).forEach(ele->{
            QueryWrapper<InTopThirtyEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("data_address",ele.getDataAddress())
                    .eq("data_date",ele.getDataDate())
                    .eq("shop_num",ele.getShopNum());
            if (inTopThirtyService.list(queryWrapper).size() == 0){
                inTopThirtyService.save(ele);
            }else {
                inTopThirtyService.update(ele,queryWrapper);
            }
        });

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InTopThirtyEntity inTopThirty){
		inTopThirtyService.updateById(inTopThirty);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		inTopThirtyService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @GetMapping("/getThirty")
    public R getThirty(@RequestParam("address")String address,@RequestParam("date")String date){
        return R.ok().put("data",inTopThirtyService.getTopThirty(address,date));
    }

    @GetMapping("/getThirtyOrder")
    public R getThirtyOrder(@RequestParam("address")String address,@RequestParam("date")String date){
        return R.ok().put("data",inTopThirtyService.getTopThirtyOrder(address,date));
    }

}
