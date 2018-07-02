package com.captain.wds.myapplication.common;

import com.captain.wds.myapplication.exception.WdsNullPointerException;

public class WdsCheckUtils {

	/**
	 * 检查是否为空
	 * 
	 * @param reference
	 *            参数
	 * @param errorMessageTemplate
	 *            参数
	 * @param <T>参数
	 * @return 返回值
	 */
	public static <T> T checkNotNull(T reference, String errorMessageTemplate) {
		if (reference == null) {
			throw new WdsNullPointerException(errorMessageTemplate);
		}
		return reference;
	}
}
