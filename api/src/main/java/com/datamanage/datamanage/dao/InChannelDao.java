package com.datamanage.datamanage.dao;

import com.datamanage.datamanage.entity.InChannelEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datamanage.datamanage.entity.NameValueEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2023-03-26 13:57:16
 */
@Mapper
public interface InChannelDao extends BaseMapper<InChannelEntity> {
	@Select("SELECT in_channel.channel_name as name,in_channel.channel_num as value FROM in_channel WHERE in_channel.channel_area = #{address} AND in_channel.channel_date = #{date} AND in_channel.type = #{type}")
    List<NameValueEntity> getChannel(String address,String date,String type);
    @Select("SELECT * FROM in_channel WHERE in_channel.channel_area = #{address} AND in_channel.channel_date = #{date} AND in_channel.type = #{type}")
    List<InChannelEntity> getChannelList(String address,String date,String type);
    @Select("SELECT\n" +
            "\tid,\n" +
            "\tchannel_name,\n" +
            "\tSUM(channel_count) channel_num,\n" +
            "\tchannel_date,\n" +
            "\tchannel_area,\n" +
            "\tSUM(channel_money) channel_money\n" +
            "FROM\n" +
            "\tin_channel\n" +
            "GROUP BY channel_name")
    List<InChannelEntity> channelList();
}
