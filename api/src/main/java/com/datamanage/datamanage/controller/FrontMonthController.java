package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;
import com.datamanage.datamanage.service.FrontMonthService;
import com.datamanage.datamanage.entity.FrontMonthEntity;
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
 * @date 2023-03-24 09:57:09
 */
@RestController
@RequestMapping("back/frontmonth")
public class FrontMonthController {
    @Autowired
    private FrontMonthService frontMonthService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = frontMonthService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		FrontMonthEntity frontMonth = frontMonthService.getById(id);

        return R.ok().put("frontMonth", frontMonth);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FrontMonthEntity frontMonth){
		frontMonthService.save(frontMonth);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FrontMonthEntity frontMonth){
		frontMonthService.updateById(frontMonth);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		frontMonthService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
