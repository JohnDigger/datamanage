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
@TableName("in_object")
public class InObjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Integer id;
	/**
	 *
	 */
	private Float objectPercent;
	/**
	 *
	 */
	private String objectName;
	/**
	 *
	 */
	private String objectAddress;
	/**
	 *
	 */
	private String objectDate;

	private String objectMoney;

	private String objectNum;

	public void setObjectMoney(String objectMoney) {
		if (objectMoney == null) {
			this.objectMoney = "0";
		}else {
			this.objectMoney = objectMoney;
		}
	}

	public void setObjectNum(String objectNum) {
		if (objectNum == null) {
			this.objectNum = "0";
		}else {
			this.objectNum = objectNum;
		}
	}
}
