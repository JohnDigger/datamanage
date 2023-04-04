package com.datamanage.datamanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.datamanage.datamanage.entity.InChannelEntity;
import com.datamanage.datamanage.entity.NameValueEntity;
import com.datamanage.datamanage.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2023-03-26 13:57:16
 */
public interface InChannelService extends IService<InChannelEntity> {

    PageUtils queryPage(Map<String, Object> params) throws Exception;
    List<NameValueEntity> getChannel(String address, String date, String type);
    List<InChannelEntity> getChannelList(String address,String date,String type);
    List<InChannelEntity> channelList();
}

