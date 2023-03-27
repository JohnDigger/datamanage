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
 * @date 2023-03-26 13:57:16
 */
@Data
@TableName("in_detail_panel")
public class InDetailPanelEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String detailCount;
	/**
	 * 
	 */
	private String detailMoney;
	/**
	 * 
	 */
	private String dataDate;
	/**
	 * 
	 */
	private String dataAddress;
	/**
	 * 
	 */
	private String type;

}
