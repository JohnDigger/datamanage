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
@TableName("in_service_analyse")
public class InServiceAnalyseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Integer id;
	/**
	 * 统计时间
	 */
	private String time;
	/**
	 * 分类名字
	 */
	private String name;
	/**
	 * 零售额（万元）
	 */
	private String saleMoney;
	/**
	 * 零售量（万件）
	 */
	private String saleNum;

	private String dataAddress;

}
