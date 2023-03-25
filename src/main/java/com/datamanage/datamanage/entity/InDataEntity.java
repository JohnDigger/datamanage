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
@TableName("in_data")
public class InDataEntity implements Serializable {
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
	 * 全网零售额
	 */
	private String totalSaleMoney;
	/**
	 * 全网零售量
	 */
	private String totalSaleNum;
	/**
	 * 店铺数量
	 */
	private String shopNum;
	/**
	 * 网售额
	 */
	private String wlSaleMoney;
	/**
	 * 网零发展指数
	 */
	private String wlDevelopment;
	/**
	 * 店铺数量
	 */
	private String wlShopNum;
	/**
	 * 网售量
	 */
	private String wlSaleNum;
	/**
	 * 从业人数
	 */
	private String wlWorkNum;

	private String dataAddress;

}
