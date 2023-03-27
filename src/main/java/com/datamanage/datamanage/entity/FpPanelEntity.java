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
 * @date 2023-03-27 15:47:26
 */
@Data
@TableName("fp_panel")
public class FpPanelEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String qxPerson;
	/**
	 * 
	 */
	private String qxArea;
	/**
	 * 
	 */
	private Integer poorNum;
	/**
	 * 
	 */
	private Integer poorPersonNum;
	/**
	 * 
	 */
	private Integer richNum;
	/**
	 * 
	 */
	private Integer richPersonNum;
	/**
	 * 
	 */
	private Integer stiilPoorNum;
	/**
	 * 
	 */
	private Integer stillPoorPersonNum;
	/**
	 * 
	 */
	private String dataAddress;

}
