package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.datamanage.datamanage.entity.InChannelEntity;
import com.datamanage.datamanage.entity.InObjectEntity;
import com.datamanage.datamanage.service.InObjectService;
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
@RequestMapping("back/inobject")
public class InObjectController {
    @Autowired
    private InObjectService inObjectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = inObjectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		InObjectEntity inObject = inObjectService.getById(id);

        return R.ok().put("inObject", inObject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody InObjectEntity[] inObject){
        Arrays.asList(inObject).forEach(ele->{
            QueryWrapper<InObjectEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("object_date",ele.getObjectDate())
                    .eq("object_name",ele.getObjectName())
                    .eq("object_address",ele.getObjectAddress());
            System.out.println(ele);
            if (inObjectService.list(queryWrapper).size() == 0){
                inObjectService.save(ele);
            }else {
                inObjectService.update(ele,queryWrapper);
            }
        });

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InObjectEntity inObject){
		inObjectService.updateById(inObject);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		inObjectService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @GetMapping("/getPer")
    public R getList(@RequestParam("address")String address,@RequestParam("date") String date){
        return R.ok().put("data",inObjectService.getList(address, date));
    }

    @GetMapping("/getObj")
    public R getObjList(@RequestParam("address")String address,@RequestParam("date") String date){
        return R.ok().put("data",inObjectService.getObjList(address, date));
    }

    @GetMapping("/getTrend")
    public R getTrend(@RequestParam("address")String address,@RequestParam("date") String date){
        return R.ok().put("data",inObjectService.getTrend(address, date));
    }


}
