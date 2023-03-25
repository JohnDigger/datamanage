package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.datamanage.datamanage.entity.InServiceAnalyseEntity;
import com.datamanage.datamanage.service.InServiceAnalyseService;
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
@RequestMapping("back/inserviceanalyse")
public class InServiceAnalyseController {
    @Autowired
    private InServiceAnalyseService inServiceAnalyseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = inServiceAnalyseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		InServiceAnalyseEntity inServiceAnalyse = inServiceAnalyseService.getById(id);

        return R.ok().put("inServiceAnalyse", inServiceAnalyse);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody InServiceAnalyseEntity inServiceAnalyse){
		inServiceAnalyseService.save(inServiceAnalyse);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InServiceAnalyseEntity inServiceAnalyse){
		inServiceAnalyseService.updateById(inServiceAnalyse);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		inServiceAnalyseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
