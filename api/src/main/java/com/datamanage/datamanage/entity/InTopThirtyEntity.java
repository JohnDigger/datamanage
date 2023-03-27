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
 * @date 2023-03-27 15:12:44
 */
@Data
@TableName("in_top_thirty")
public class InTopThirtyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String goodsName;
	/**
	 * 
	 */
	private String shopName;
	/**
	 * 
	 */
	private String saleMoney;
	/**
	 * 
	 */
	private Integer saleNum;
	/**
	 * 
	 */
	private String saleChannel;
	/**
	 * 
	 */
	private String dataAddress;

}
