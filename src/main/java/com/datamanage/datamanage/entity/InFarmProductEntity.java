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
 * @date 2023-03-26 00:58:52
 */
@Data
@TableName("in_farm_product")
public class InFarmProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Float farmMoney;
	/**
	 * 
	 */
	private Float farmNum;
	/**
	 * 
	 */
	private String farmAddress;
	/**
	 * 
	 */
	private String farmDate;

}
