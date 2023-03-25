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
@TableName("in_service")
public class InServiceEntity implements Serializable {
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
	 * 渠道分析-美团
	 */
	private String meituan;
	/**
	 * 渠道分析-饿了么
	 */
	private String elema;
	/**
	 * 渠道分析-美团团购
	 */
	private String tuangou;
	/**
	 * 渠道分析-其他
	 */
	private String other;

	private String dataAddress;

}
