package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.datamanage.datamanage.entity.InFarmScaleEntity;
import com.datamanage.datamanage.service.InFarmScaleService;


/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2023-03-27 15:12:44
 */
@RestController
@RequestMapping("back/infarmscale")
public class InFarmScaleController {
    @Autowired
    private InFarmScaleService inFarmScaleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = inFarmScaleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		InFarmScaleEntity inFarmScale = inFarmScaleService.getById(id);

        return R.ok().put("inFarmScale", inFarmScale);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody InFarmScaleEntity inFarmScale){
		inFarmScaleService.save(inFarmScale);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InFarmScaleEntity inFarmScale){
		inFarmScaleService.updateById(inFarmScale);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		inFarmScaleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @GetMapping("/getPanel")
    public R getPanel(@RequestParam("address")String address,@RequestParam("date")String date){
        return R.ok().put("data",inFarmScaleService.getPanel(address, date));

    }
}
