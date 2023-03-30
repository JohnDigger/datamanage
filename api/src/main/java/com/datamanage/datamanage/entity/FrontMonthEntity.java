package com.datamanage.datamanage.entity;

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
 * @date 2023-03-24 09:57:09
 */
@Data
@TableName("front_month")
public class FrontMonthEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Integer id;
	/**
	 *
	 */
	@NotEmpty
	@NotNull
	private String frontDate;

	private String dataAddressId;

	private String isEdited;

}
