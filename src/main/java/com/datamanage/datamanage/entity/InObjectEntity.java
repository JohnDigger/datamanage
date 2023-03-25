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
 * @date 2023-03-23 20:26:35
 */
@Data
@TableName("in_object")
public class InObjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Integer id;
	/**
	 * 统计时间
	 */
	private String time;
	/**
	 * 网络零售额
	 */
	private String saleMoney;
	/**
	 * 网络零售量
	 */
	private String saleNum;
	/**
	 * 渠道分析-京东
	 */
	private String jingdong;
	/**
	 * 渠道分析-天猫
	 */
	private String tianmao;
	/**
	 * 渠道分析-淘宝
	 */
	private String taobao;
	/**
	 * 渠道分析-其他
	 */
	private String other;

	private String dataAddress;

}
