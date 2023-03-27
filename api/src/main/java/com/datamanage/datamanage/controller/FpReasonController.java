package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.datamanage.datamanage.entity.FpReasonEntity;
import com.datamanage.datamanage.service.FpReasonService;
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
@RequestMapping("back/fpreason")
public class FpReasonController {
    @Autowired
    private FpReasonService fpReasonService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = fpReasonService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		FpReasonEntity fpReason = fpReasonService.getById(id);

        return R.ok().put("fpReason", fpReason);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FpReasonEntity fpReason){
		fpReasonService.save(fpReason);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FpReasonEntity fpReason){
		fpReasonService.updateById(fpReason);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		fpReasonService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @GetMapping("/reason")
    public R reason(@RequestParam("address") String address){
        return R.ok().put("data",fpReasonService.fpReason(address));
    }

}
