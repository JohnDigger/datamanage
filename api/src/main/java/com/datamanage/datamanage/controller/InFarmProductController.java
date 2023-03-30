package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.datamanage.datamanage.entity.InChannelEntity;
import com.datamanage.datamanage.entity.InFarmProductEntity;
import com.datamanage.datamanage.entity.InFarmScaleEntity;
import com.datamanage.datamanage.service.InFarmProductService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2023-03-26 00:58:52
 */
@RestController
@RequestMapping("back/infarmproduct")
public class InFarmProductController {
    @Autowired
    private InFarmProductService inFarmProductService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = inFarmProductService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		InFarmProductEntity inFarmProduct = inFarmProductService.getById(id);

        return R.ok().put("inFarmProduct", inFarmProduct);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody List<InFarmProductEntity> inFarmProduct){
        inFarmProduct.forEach(ele->{
            QueryWrapper<InFarmProductEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("farm_date",ele.getFarmDate())
                    .eq("farm_address",ele.getFarmAddress())
                    .eq("farm_name",ele.getFarmName());
            if (inFarmProductService.list(queryWrapper).size() == 0){
                inFarmProductService.save(ele);
            }else {
                inFarmProductService.update(ele,queryWrapper);
            }
        });

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InFarmProductEntity inFarmProduct){
		inFarmProductService.updateById(inFarmProduct);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		inFarmProductService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @GetMapping("/product")
    public R product(@RequestParam("address") String address,@RequestParam("date")String date){
        return R.ok().put("data",inFarmProductService.getProduct(address, date));
    }

}
