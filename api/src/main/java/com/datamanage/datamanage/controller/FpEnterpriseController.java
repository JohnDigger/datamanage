package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.datamanage.datamanage.entity.FpEnterpriseEntity;
import com.datamanage.datamanage.service.FpEnterpriseService;
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
@RequestMapping("back/fpenterprise")
public class FpEnterpriseController {
    @Autowired
    private FpEnterpriseService fpEnterpriseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = fpEnterpriseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		FpEnterpriseEntity fpEnterprise = fpEnterpriseService.getById(id);

        return R.ok().put("fpEnterprise", fpEnterprise);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FpEnterpriseEntity fpEnterprise){
		fpEnterpriseService.save(fpEnterprise);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FpEnterpriseEntity fpEnterprise){
		fpEnterpriseService.updateById(fpEnterprise);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		fpEnterpriseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @GetMapping(value = "/getTwenty")
    public R getTwenty(@RequestParam("dataAddress") String dataAddress){
        return R.ok().put("enterprise",fpEnterpriseService.getTopTwenty(dataAddress));
    }

}
