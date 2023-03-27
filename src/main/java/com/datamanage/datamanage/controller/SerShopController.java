package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.datamanage.datamanage.entity.SerShopEntity;
import com.datamanage.datamanage.service.SerShopService;
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
@RequestMapping("back/sershop")
public class SerShopController {
    @Autowired
    private SerShopService serShopService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = serShopService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		SerShopEntity serShop = serShopService.getById(id);

        return R.ok().put("serShop", serShop);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SerShopEntity serShop){
		serShopService.save(serShop);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SerShopEntity serShop){
		serShopService.updateById(serShop);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		serShopService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @GetMapping("/getTop")
    public R getTop(@RequestParam("address") String address,@RequestParam("type") String type){
        return R.ok().put("data",serShopService.getTopAmount(address,type));
    }

    @GetMapping("/getCount")
    public R getTopCount(@RequestParam("address") String address,@RequestParam("type") String type){
        return R.ok().put("data",serShopService.getTopCount(address,type));
    }

}
