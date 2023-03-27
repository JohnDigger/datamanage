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
@TableName("ser_order_list")
public class SerOrderListEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Long serOrderNum;
	/**
	 * 
	 */
	private String serOrderType;
	/**
	 * 
	 */
	private Long serOrderAmmount;
	/**
	 * 
	 */
	private String serOrderName;
	/**
	 * 
	 */
	private String serOrderDate;

	private String dataAddress;

}
