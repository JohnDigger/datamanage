package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.datamanage.datamanage.entity.InDataEntity;
import com.datamanage.datamanage.service.InDataService;
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
@RequestMapping("back/indata")
public class InDataController {
    @Autowired
    private InDataService inDataService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = inDataService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		InDataEntity inData = inDataService.getById(id);

        return R.ok().put("inData", inData);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody InDataEntity inData){
        QueryWrapper<InDataEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("time", inData.getTime())
                .eq("data_address",inData.getDataAddress());

        if (inDataService.list(queryWrapper).size() == 0){
            inDataService.save(inData);

        } else{
            inDataService.update(inData,queryWrapper);
        }

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InDataEntity inData){
		inDataService.updateById(inData);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		inDataService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @GetMapping("getPanel")
    public R panel(@RequestParam("address")String address,@RequestParam("dateTime")String dateTime){
        return R.ok().put("data",inDataService.getPanel(address, dateTime));
    }

    @GetMapping("/getList")
    public R getList(@RequestParam("year")String year,@RequestParam("month")String month,@RequestParam("address")String address){
        return R.ok().put("data",inDataService.getList(year, month,address));
    }
    @GetMapping("/getAll")
    public R getMap(){
        return R.ok().put("data",inDataService.getAll());
    }
}
