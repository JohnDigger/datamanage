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
@TableName("in_detail_table")
public class InDetailTableEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String detailName;
	/**
	 * 
	 */
	private String detailDate;
	/**
	 * 
	 */
	private String detailMoney;
	/**
	 * 
	 */
	private String dataAddress;
	/**
	 * 
	 */
	private String type;

}
