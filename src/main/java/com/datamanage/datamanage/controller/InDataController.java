package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;


import com.datamanage.datamanage.entity.InDataEntity;
import com.datamanage.datamanage.service.InDataService;
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
		inDataService.save(inData);

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

}
