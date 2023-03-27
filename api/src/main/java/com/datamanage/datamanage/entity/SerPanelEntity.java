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
@TableName("ser_panel")
public class SerPanelEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer saleNum;
	/**
	 * 
	 */
	private Integer buyNum;
	/**
	 * 
	 */
	private Integer serNum;
	/**
	 * 
	 */
	private Integer townNum;
	/**
	 * 
	 */
	private Integer villageNum;
	/**
	 * 
	 */
	private String serRane;
	/**
	 * 
	 */
	private String dataAddress;
	/**
	 * 
	 */
	private String dataDate;

}
