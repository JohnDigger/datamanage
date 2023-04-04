package com.datamanage.datamanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.datamanage.datamanage.entity.FrontAddressEntity;
import com.datamanage.datamanage.entity.FrontMonthEntity;
import com.datamanage.datamanage.service.FrontAddressService;
import com.datamanage.datamanage.service.FrontMonthService;
import com.datamanage.datamanage.utils.DateUtils;
import com.datamanage.datamanage.utils.PageUtils;
import com.datamanage.datamanage.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 *
 *
 * @author ${author}
 * @email ${email}
 * @date 2023-03-24 15:02:27
 */
@CrossOrigin
@RestController
@RequestMapping("back/frontaddress")
public class FrontAddressController {
    @Autowired
    private FrontAddressService frontAddressService;
    @Autowired
    private FrontMonthService frontMonthService;
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
        List<String> dateList = new ArrayList<>();
        dateList = DateUtils.getYearMonths(frontAddress.getStartTime(),frontAddress.getEndTime());
        dateList.forEach(ele ->{
            FrontMonthEntity frontMonthEntity  = new FrontMonthEntity();
            frontMonthEntity.setFrontDate(ele);
            frontMonthEntity.setDataAddressId(String.valueOf(frontAddress.getId()));
            frontMonthEntity.setIsEdited("0");
            frontMonthService.save(frontMonthEntity);
        });

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestParam("address")String address,@RequestParam("image_url")String url){
        QueryWrapper<FrontAddressEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("data_address",address);
        if (frontAddressService.list(queryWrapper).size() == 0){
            return R.error("failed");
        }else {
            FrontAddressEntity frontAddressEntity = new FrontAddressEntity();
            frontAddressEntity.setDataAddress(address);
            frontAddressEntity.setImageUrl(url);
            frontAddressService.update(frontAddressEntity,queryWrapper);
        }
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

    @GetMapping("/insertDate")
    public void insertDate(@RequestParam("startTime")String startTime,
                        @RequestParam("endTime")String endTime){
        System.out.println(DateUtils.getYearMonths(startTime, endTime));
    }

    @GetMapping("getImage")
    public R getImage(@RequestParam("address")String address){
        QueryWrapper<FrontAddressEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("data_address",address);
        return R.ok().put("data",frontAddressService.list(queryWrapper));
    }

}
