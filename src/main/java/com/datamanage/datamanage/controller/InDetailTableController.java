package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.datamanage.datamanage.entity.InDetailTableEntity;
import com.datamanage.datamanage.service.InDetailTableService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2023-03-26 13:57:16
 */
@RestController
@RequestMapping("back/indetailtable")
public class InDetailTableController {
    @Autowired
    private InDetailTableService inDetailTableService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = inDetailTableService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		InDetailTableEntity inDetailTable = inDetailTableService.getById(id);

        return R.ok().put("inDetailTable", inDetailTable);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody InDetailTableEntity inDetailTable){
		inDetailTableService.save(inDetailTable);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InDetailTableEntity inDetailTable){
		inDetailTableService.updateById(inDetailTable);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		inDetailTableService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @GetMapping("/getTable")
    public R getTable(@RequestParam("date")String date,@RequestParam("address")String address,@RequestParam("type")String type){
        return R.ok().put("data",inDetailTableService.getTable(date, address, type));
    }

}
