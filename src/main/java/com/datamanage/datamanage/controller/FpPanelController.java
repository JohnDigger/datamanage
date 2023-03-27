package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.datamanage.datamanage.entity.FpPanelEntity;
import com.datamanage.datamanage.service.FpPanelService;
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
@RequestMapping("back/fppanel")
public class FpPanelController {
    @Autowired
    private FpPanelService fpPanelService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = fpPanelService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		FpPanelEntity fpPanel = fpPanelService.getById(id);

        return R.ok().put("fpPanel", fpPanel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FpPanelEntity fpPanel){
		fpPanelService.save(fpPanel);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FpPanelEntity fpPanel){
		fpPanelService.updateById(fpPanel);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		fpPanelService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @GetMapping("/getList")
    public R getList(@RequestParam("address")String address){
        return R.ok().put("data",fpPanelService.getList(address));
    }

}
