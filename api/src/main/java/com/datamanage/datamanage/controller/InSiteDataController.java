package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.datamanage.datamanage.entity.InSiteDataEntity;
import com.datamanage.datamanage.service.InSiteDataService;
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
@RequestMapping("back/insitedata")
public class InSiteDataController {
    @Autowired
    private InSiteDataService inSiteDataService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = inSiteDataService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		InSiteDataEntity inSiteData = inSiteDataService.getById(id);

        return R.ok().put("inSiteData", inSiteData);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody InSiteDataEntity inSiteData){
		inSiteDataService.save(inSiteData);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InSiteDataEntity inSiteData){
		inSiteDataService.updateById(inSiteData);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		inSiteDataService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @GetMapping("/sitedata")
    public R site(@RequestParam("address")String address){
        return R.ok().put("data",inSiteDataService.getSite(address));

    }
}
