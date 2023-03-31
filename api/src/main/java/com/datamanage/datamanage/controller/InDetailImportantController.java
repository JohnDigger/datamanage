package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.datamanage.datamanage.entity.InDataEntity;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.datamanage.datamanage.entity.InDetailImportantEntity;
import com.datamanage.datamanage.service.InDetailImportantService;




/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2023-03-31 16:15:20
 */
@RestController
@RequestMapping("back/indetailimportant")
public class InDetailImportantController {
    @Autowired
    private InDetailImportantService inDetailImportantService;

    /**
     * 列表
     */
    @RequestMapping("/list")

    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = inDetailImportantService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		InDetailImportantEntity inDetailImportant = inDetailImportantService.getById(id);

        return R.ok().put("inDetailImportant", inDetailImportant);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody InDetailImportantEntity inDetailImportant){
        QueryWrapper<InDetailImportantEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("data_date", inDetailImportant.getDataDate())
                .eq("data_address",inDetailImportant.getDataAddress())
                .eq("type",inDetailImportant.getType());

        if (inDetailImportantService.list(queryWrapper).size() == 0){
            inDetailImportantService.save(inDetailImportant);

        } else{
            inDetailImportantService.update(inDetailImportant,queryWrapper);
        }

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InDetailImportantEntity inDetailImportant){
		inDetailImportantService.updateById(inDetailImportant);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		inDetailImportantService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @GetMapping("/getImportant")
    public R getList(@RequestParam("address")String address,@RequestParam("date")String date,@RequestParam("type")String type){
        return R.ok().put("data",inDetailImportantService.getList(address, date, type));
    }

}
