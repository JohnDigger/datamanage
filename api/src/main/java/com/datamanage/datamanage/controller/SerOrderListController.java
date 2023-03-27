package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.datamanage.datamanage.entity.SerOrderListEntity;
import com.datamanage.datamanage.service.SerOrderListService;
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
@RequestMapping("back/serorderlist")
public class SerOrderListController {
    @Autowired
    private SerOrderListService serOrderListService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = serOrderListService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		SerOrderListEntity serOrderList = serOrderListService.getById(id);

        return R.ok().put("serOrderList", serOrderList);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SerOrderListEntity serOrderList){
		serOrderListService.save(serOrderList);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SerOrderListEntity serOrderList){
		serOrderListService.updateById(serOrderList);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		serOrderListService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @GetMapping("/getRankOrder")
    public R rank(@RequestParam("address")String address,@RequestParam("time") String time){
        return R.ok().put("data",serOrderListService.getRank(address, time));
    }

}
