package com.datamanage.datamanage.controller;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.datamanage.datamanage.entity.InDetailTopEntity;
import com.datamanage.datamanage.entity.InObjectEntity;
import com.datamanage.datamanage.service.InDetailTopService;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2023-03-26 13:57:16
 */
@RestController
@RequestMapping("back/indetailtop")
public class InDetailTopController {
    @Autowired
    private InDetailTopService inDetailTopService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = inDetailTopService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		InDetailTopEntity inDetailTop = inDetailTopService.getById(id);

        return R.ok().put("inDetailTop", inDetailTop);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody InDetailTopEntity[] inDetailTop){
        Arrays.asList(inDetailTop).forEach(ele->{
            QueryWrapper<InDetailTopEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("data_address",ele.getDataAddress())
                    .eq("data_date",ele.getDataDate())
                    .eq("type",ele.getType())
                    .eq("detail_num",ele.getDetailNum());
            if (inDetailTopService.list(queryWrapper).size() == 0){
                inDetailTopService.save(ele);
            }else {
                inDetailTopService.update(ele,queryWrapper);
            }
        });

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InDetailTopEntity inDetailTop){
		inDetailTopService.updateById(inDetailTop);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		inDetailTopService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @GetMapping("/getTen")
    public R getTop(@RequestParam("address")String address,@RequestParam("date")String date,@RequestParam("type")String type){
        return R.ok().put("data",inDetailTopService.getTopTen(date,address , type));
    }

    @GetMapping("/getTenByOrder")
    public R getTenByOrder(@RequestParam("address")String address,@RequestParam("date")String date,@RequestParam("type")String type){
        return R.ok().put("data",inDetailTopService.getTopTenOrder(date,address ,type));
    }

}
