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
@TableName("in_shop")
public class InShopEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Integer id;
	/**
	 * 统计时间
	 */
	private String shopTime;
	/**
	 * 序号
	 */
	private String shopIndex;
	/**
	 * 店铺名称
	 */
	private String name;
	/**
	 * 零售额
	 */
	private String saleMoney;
	/**
	 * 零售量
	 */
	private String saleNum;
	/**
	 * 所属平台
	 */
	private String belongTo;

	private String dataAddress;

	private String shopUrl;

}
