package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.datamanage.datamanage.entity.SerTypeEntity;
import com.datamanage.datamanage.service.SerTypeService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.R;
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
@RequestMapping("back/sertype")
public class SerTypeController {
    @Autowired
    private SerTypeService serTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = serTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		SerTypeEntity serType = serTypeService.getById(id);

        return R.ok().put("serType", serType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SerTypeEntity serType){
		serTypeService.save(serType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SerTypeEntity serType){
		serTypeService.updateById(serType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		serTypeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @GetMapping("/getType")
    public R getType(@RequestParam("address") String address){
        return R.ok().put("data",serTypeService.getSerType(address));
    }

}
