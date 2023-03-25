package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.datamanage.datamanage.entity.InObjectAnalyseEntity;
import com.datamanage.datamanage.service.InObjectAnalyseService;
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
@RequestMapping("back/inobjectanalyse")
public class InObjectAnalyseController {
    @Autowired
    private InObjectAnalyseService inObjectAnalyseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = inObjectAnalyseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		InObjectAnalyseEntity inObjectAnalyse = inObjectAnalyseService.getById(id);

        return R.ok().put("inObjectAnalyse", inObjectAnalyse);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody InObjectAnalyseEntity inObjectAnalyse){
		inObjectAnalyseService.save(inObjectAnalyse);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InObjectAnalyseEntity inObjectAnalyse){
		inObjectAnalyseService.updateById(inObjectAnalyse);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		inObjectAnalyseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
