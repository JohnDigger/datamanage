package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.datamanage.datamanage.entity.InProduceCompareEntity;
import com.datamanage.datamanage.service.InProduceCompareService;
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
@RequestMapping("back/inproducecompare")
public class InProduceCompareController {
    @Autowired
    private InProduceCompareService inProduceCompareService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = inProduceCompareService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		InProduceCompareEntity inProduceCompare = inProduceCompareService.getById(id);

        return R.ok().put("inProduceCompare", inProduceCompare);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody InProduceCompareEntity inProduceCompare){
		inProduceCompareService.save(inProduceCompare);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InProduceCompareEntity inProduceCompare){
		inProduceCompareService.updateById(inProduceCompare);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		inProduceCompareService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
