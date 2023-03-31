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
 * @date 2023-03-31 16:15:20
 */
@Data
@TableName("in_detail_important")
public class InDetailImportantEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String dataAddress;
	/**
	 * 
	 */
	private String dataDate;
	/**
	 * 
	 */
	private String type;
	/**
	 * 
	 */
	private String detailCount;
	/**
	 * 
	 */
	private String detailMoney;

}
