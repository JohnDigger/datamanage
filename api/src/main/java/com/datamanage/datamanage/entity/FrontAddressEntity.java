package com.datamanage.datamanage.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 *
 * @author ${author}
 * @email ${email}
 * @date 2023-03-24 15:02:27
 */
@Data
@TableName("front_address")
public class FrontAddressEntity implements Serializable {
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

	private String level2Url;

	private String platformService;

	private String imageUrl;

	@TableField(exist = false)
	private String startTime;
	@TableField(exist = false)
	private String endTime;

}
