package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.datamanage.datamanage.entity.InAllYearEntity;
import com.datamanage.datamanage.service.InAllYearService;
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
@RequestMapping("back/inallyear")
public class InAllYearController {
    @Autowired
    private InAllYearService inAllYearService;


    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = inAllYearService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		InAllYearEntity inAllYear = inAllYearService.getById(id);

        return R.ok().put("inAllYear", inAllYear);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody InAllYearEntity inAllYear){
		inAllYearService.save(inAllYear);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InAllYearEntity inAllYear){
		inAllYearService.updateById(inAllYear);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		inAllYearService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
    @GetMapping("getData")
    public R getData(@RequestParam("address")String address){
        return R.ok().put("data",inAllYearService.getData(address));
    }

}
