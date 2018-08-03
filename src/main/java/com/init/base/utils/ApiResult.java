package com.init.base.utils;

import com.alibaba.fastjson.JSONObject;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wujiaxing
 * @date 2018年8月3日
 */
@Data
@Slf4j
public class ApiResult {

	private Integer code;
	private String msg;
	private Object data;

	public ApiResult(Integer code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public static ApiResult success(String msg, Object data) {
		return new ApiResult(0, msg, data);
	}

	public static ApiResult success(Object data) {
		return new ApiResult(0, null, data);
	}

	public static ApiResult success() {
		return new ApiResult(0, null, null);
	}

	public static ApiResult fail(Integer code, String msg) {
		ApiResult result = new ApiResult(code, msg, null);
		log.debug(JSONObject.toJSONString(result));
		return result;
	}

	public static ApiResult fail(String msg) {
		ApiResult result = new ApiResult(-1, msg, null);
		log.debug(JSONObject.toJSONString(result));
		return result;
	}

}
