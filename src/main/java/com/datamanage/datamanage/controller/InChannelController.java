package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.datamanage.datamanage.entity.InChannelEntity;
import com.datamanage.datamanage.service.InChannelService;
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
@RequestMapping("back/inchannel")
public class InChannelController {
    @Autowired
    private InChannelService inChannelService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = inChannelService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		InChannelEntity inChannel = inChannelService.getById(id);

        return R.ok().put("inChannel", inChannel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody InChannelEntity inChannel){
		inChannelService.save(inChannel);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InChannelEntity inChannel){
		inChannelService.updateById(inChannel);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		inChannelService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @GetMapping("/channel")
    public R getChannel(@RequestParam("address")String address,@RequestParam("date")String date,@RequestParam("type")String type){
        return R.ok().put("data",inChannelService.getChannel(address, date, type));
    }

}
