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
@TableName("ser_sell_half_year")
public class SerSellHalfYearEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String orderTime;
	/**
	 * 
	 */
	private String orderAmmount;
	/**
	 * 
	 */
	private String orderDate;
	/**
	 * 
	 */
	private String type;

	private String dataAddress;

}
