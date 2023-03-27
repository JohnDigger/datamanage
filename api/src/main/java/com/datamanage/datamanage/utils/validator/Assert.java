/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.datamanage.datamanage.utils.validator;

import org.apache.commons.lang.StringUtils;

/**
 * 数据校验
 *
 * @author Mark
 */
public abstract class Assert {

    public static void isBlank(String str, String message) throws Exception {
        if (StringUtils.isBlank(str)) {
            throw new Exception(message);
        }
    }

    public static void isNull(Object object, String message) throws Exception {
        if (object == null) {
            throw new Exception(message);
        }
    }
}
