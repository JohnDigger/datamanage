package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.datamanage.datamanage.entity.InAllYearTrendEntity;
import com.datamanage.datamanage.service.InAllYearTrendService;
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
@RequestMapping("back/inallyeartrend")
public class InAllYearTrendController {
    @Autowired
    private InAllYearTrendService inAllYearTrendService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = inAllYearTrendService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		InAllYearTrendEntity inAllYearTrend = inAllYearTrendService.getById(id);

        return R.ok().put("inAllYearTrend", inAllYearTrend);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody InAllYearTrendEntity inAllYearTrend){
		inAllYearTrendService.save(inAllYearTrend);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InAllYearTrendEntity inAllYearTrend){
		inAllYearTrendService.updateById(inAllYearTrend);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		inAllYearTrendService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @GetMapping("/trendMoney")
    public R money(@RequestParam("data")String data){
        return R.ok().put("data",inAllYearTrendService.getMoney(data));
    }

    @GetMapping("/trendCount")
    public R count(@RequestParam("data")String data){
        return R.ok().put("data",inAllYearTrendService.getCount(data));
    }


}
