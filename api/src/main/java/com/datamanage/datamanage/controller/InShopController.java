package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.datamanage.datamanage.dao.InShopDao;
import com.datamanage.datamanage.entity.InShopEntity;
import com.datamanage.datamanage.service.InShopService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.R;
import com.fasterxml.jackson.databind.ObjectMapper;
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
@RequestMapping("back/inshop")
public class InShopController {
    @Autowired
    private InShopService inShopService;
    private final ObjectMapper objectMapper = new ObjectMapper();
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = inShopService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		InShopEntity inShop = inShopService.getById(id);

        return R.ok().put("inShop", inShop);
    }

    /**
     * 保存
     */
    @Autowired
    private InShopDao inShopDao;
    @RequestMapping("/save")
    public R save(@RequestBody Object params){
        List<Map<String, Object>> list = (List<Map<String, Object>>) params;
        for (Map<String, Object> obj : list) {
            int index = (int) obj.get("index");
            String name = (String) obj.get("name");
            String belongTo = (String) obj.get("belongTo");
            String time = (String) obj.get("time");
            String dataAddress = (String)obj.get("dataAddress");
//            String saleMoney = (String)obj.get("saleMoney");
//            String saleNum = (String)obj.get("saleNum");
            System.out.println(name+belongTo+time+dataAddress);
            // 处理对象中的属性
            InShopEntity inShopEntity = new InShopEntity();
            inShopEntity.setName(name);
            inShopEntity.setIndex(String.valueOf(index));
            inShopEntity.setBelongTo(belongTo);
            inShopEntity.setTime(time);
            inShopEntity.setDataAddress(dataAddress);
//            inShopEntity.setSaleNum(saleNum);
//            inShopEntity.setSaleMoney(saleMoney);
//            inShopService.save(inShopEntity);
//            inShopDao.insert(inShopEntity);
            inShopDao.insertInShop(index, name, belongTo, dataAddress, time);
        }

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InShopEntity inShop){
		inShopService.updateById(inShop);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		inShopService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
    @GetMapping("getAll")
    public R shops(@RequestParam("address")String address){
        return R.ok().put("data",inShopService.getAll(address));
    }

}
