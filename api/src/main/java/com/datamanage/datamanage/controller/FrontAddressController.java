package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.datamanage.datamanage.entity.FrontAddressEntity;
import com.datamanage.datamanage.service.FrontAddressService;
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
 * @date 2023-03-24 15:02:27
 */
@RestController
@RequestMapping("back/frontaddress")
public class FrontAddressController {
    @Autowired
    private FrontAddressService frontAddressService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = frontAddressService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		FrontAddressEntity frontAddress = frontAddressService.getById(id);

        return R.ok().put("frontAddress", frontAddress);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FrontAddressEntity frontAddress){
		frontAddressService.save(frontAddress);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FrontAddressEntity frontAddress){
		frontAddressService.updateById(frontAddress);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		frontAddressService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
