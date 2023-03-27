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
@TableName("in_farm_scale")
public class InFarmScaleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
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
	private String top1Sale;
	/**
	 * 
	 */
	private String saleDate;
	/**
	 * 
	 */
	private String dataAddress;

}
