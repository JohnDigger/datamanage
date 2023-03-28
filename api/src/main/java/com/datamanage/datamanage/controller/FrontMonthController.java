package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.datamanage.datamanage.entity.FrontAddressEntity;
import com.datamanage.datamanage.service.FrontAddressService;
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
    @Autowired
    private FrontAddressService frontAddressService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = frontMonthService.queryPage(params);
        Integer id =  frontAddressService.list(new QueryWrapper<FrontAddressEntity>().eq("data_address",params.get("addressName")).select("id")).get(0).getId();
        List<FrontMonthEntity> frontMonthEntities = frontMonthService.list(new QueryWrapper<FrontMonthEntity>().select("front_date").eq("data_address_id",id));
        page.setList(frontMonthEntities);
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
    public R save(@RequestBody FrontMonthEntity frontMonth,@RequestParam("addressName")String addressName){
        System.out.println(frontMonth);
        System.out.println(addressName);
        Integer id =  frontAddressService.list(new QueryWrapper<FrontAddressEntity>().eq("data_address",addressName).select("id")).get(0).getId();
        frontMonth.setDataAddressId(String.valueOf(id));
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
