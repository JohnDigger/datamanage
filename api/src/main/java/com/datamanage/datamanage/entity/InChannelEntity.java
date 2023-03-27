package com.datamanage.datamanage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2023-03-26 13:57:16
 */
@Data
@TableName("in_channel")
public class InChannelEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String channelName;
	/**
	 * 
	 */
	private Float channelNum;
	/**
	 * 
	 */
	private String channelDate;
	/**
	 * 
	 */
	private String channelArea;
	/**
	 * 
	 */
	private String type;

}
