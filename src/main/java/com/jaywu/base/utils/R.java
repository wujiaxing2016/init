package com.jaywu.base.utils;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * REST API 返回结果
 * </p>
 *
 * @author wujiaxing
 * @email jiaxing.wu@qq.com
 * @since 2018-12-12
 * @param data值类型
 */
@Data
@Accessors(chain = true)
public class R<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 返回状态码
	 */
	private Integer code;
	/**
	 * 返回描述信息
	 */
	private String msg;
	/**
	 * 返回值写到这里
	 */
	private T data;

	public R() {
	}

	public R(R.Status status, T data) {
		super();
		this.code = status.getCode();
		this.msg = status.getMsg();
		this.data = data;
	}

	public static <T> R<T> success(R.Status status, T data) {
		return new R<T>(status, data);
	}

	public static <T> R<T> success(T data) {
		return new R<T>(R.Status.SUCCESS, data);
	}

	public static <T> R<T> success() {
		return new R<T>(R.Status.SUCCESS, null);
	}

	public static <T> R<T> fail() {
		return new R<T>(R.Status.FAIL, null);
	}

	public static <T> R<T> fail(R.Status status) {
		return new R<T>(status, null);
	}

	/**
	 * <p>
	 * REST API 返回枚举
	 * </p>
	 *
	 * @author wujiaxing
	 * @email jiaxing.wu@qq.com
	 * @since 2018-12-12
	 */
	public enum Status {
		SUCCESS(0, "success"), // 成功
		FAIL(-1, "fail"), // 失败
		PARAM_ERROR(-2, "参数不全") // 参数不全
		;
		private Integer code;
		private String msg;

		Status(Integer code, String msg) {
			this.code = code;
			this.msg = msg;
		}

		public Integer getCode() {
			return code;
		}

		public String getMsg() {
			return msg;
		}
	}

}
