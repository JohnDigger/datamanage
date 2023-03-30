package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.datamanage.datamanage.entity.InObjectEntity;
import com.datamanage.datamanage.entity.InServiceEntity;
import com.datamanage.datamanage.service.InServiceService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2023-03-26 00:58:52
 */
@RestController
@RequestMapping("back/inservice")
public class InServiceController {
    @Autowired
    private InServiceService inServiceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = inServiceService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		InServiceEntity inService = inServiceService.getById(id);

        return R.ok().put("inService", inService);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody InServiceEntity[] inService){
        Arrays.asList(inService).forEach(ele->{
            QueryWrapper<InServiceEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("service_date",ele.getServiceDate())
                    .eq("service_name",ele.getServiceName())
                    .eq("service_address",ele.getServiceAddress());
            if (inServiceService.list(queryWrapper).size() == 0){
                inServiceService.save(ele);
            }else {
                inServiceService.update(ele,queryWrapper);
            }
        });
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InServiceEntity inService){
		inServiceService.updateById(inService);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		inServiceService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @GetMapping("/getService")
    public R getService(@RequestParam("address")String address,@RequestParam("date")String date){
        return R.ok().put("data",inServiceService.getService(address, date));
    }
}
