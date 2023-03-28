package com.datamanage.datamanage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
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
	@NotNull
	@NotEmpty
	private String dataAddress;
	@NotNull
	@NotEmpty
	private String level2Url;
	@NotNull
	@NotEmpty
	private String platformService;

}
