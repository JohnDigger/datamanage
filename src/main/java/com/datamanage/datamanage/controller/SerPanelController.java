package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.datamanage.datamanage.entity.SerPanelEntity;
import com.datamanage.datamanage.service.SerPanelService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2023-03-23 20:26:35
 */
@RestController
@RequestMapping("back/serpanel")
public class SerPanelController {
    @Autowired
    private SerPanelService serPanelService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = serPanelService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		SerPanelEntity serPanel = serPanelService.getById(id);

        return R.ok().put("serPanel", serPanel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SerPanelEntity serPanel){
		serPanelService.save(serPanel);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SerPanelEntity serPanel){
		serPanelService.updateById(serPanel);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		serPanelService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
