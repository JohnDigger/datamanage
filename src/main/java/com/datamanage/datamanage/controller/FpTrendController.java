package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.datamanage.datamanage.entity.FpTrendEntity;
import com.datamanage.datamanage.service.FpTrendService;
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
@RequestMapping("back/fptrend")
public class FpTrendController {
    @Autowired
    private FpTrendService fpTrendService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = fpTrendService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		FpTrendEntity fpTrend = fpTrendService.getById(id);

        return R.ok().put("fpTrend", fpTrend);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FpTrendEntity fpTrend){
		fpTrendService.save(fpTrend);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FpTrendEntity fpTrend){
		fpTrendService.updateById(fpTrend);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		fpTrendService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @GetMapping("/trend")
    public R trend(@RequestParam("address")String address,@RequestParam("time") String time){
        return R.ok().put("trend",fpTrendService.getTrend(address, time));
    }

}
