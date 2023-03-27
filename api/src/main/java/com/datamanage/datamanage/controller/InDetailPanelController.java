package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.datamanage.datamanage.entity.InDetailPanelEntity;
import com.datamanage.datamanage.service.InDetailPanelService;
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
@RequestMapping("back/indetailpanel")
public class InDetailPanelController {
    @Autowired
    private InDetailPanelService inDetailPanelService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = inDetailPanelService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		InDetailPanelEntity inDetailPanel = inDetailPanelService.getById(id);

        return R.ok().put("inDetailPanel", inDetailPanel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody InDetailPanelEntity inDetailPanel){
		inDetailPanelService.save(inDetailPanel);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InDetailPanelEntity inDetailPanel){
		inDetailPanelService.updateById(inDetailPanel);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		inDetailPanelService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
    @GetMapping("/panel")
    public R panel(@RequestParam("address")String address,@RequestParam("date")String date,@RequestParam("type")String type){
        return R.ok().put("data",inDetailPanelService.getPanel(address, date, type));
    }

}
