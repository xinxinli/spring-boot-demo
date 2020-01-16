package com.eshore.project.springbootdemo.util;

import java.io.Serializable;

/**
 * 前端交互操作结果类
 * @author eshore
 */
public class BaseRes<T> implements Serializable {

	private static final long serialVersionUID = 4358865628054428464L;

	/** 成功编码 */
	public static final String CODE_SUCCESS = "0";

	/** 成功提示语 */
	public static final String MSG_SUCCESS = "操作成功！";

	/** 参数错误 */
	public static final String CODE_PARAM_ERROR = "2";

	/** 参数错误提示语 */
	public static final String MSG_PARAM_ERROR = "参数错误！";

	/** 系统异常 */
	public static final String CODE_SYSERROR = "99";

	/** 系统异常提示语 */
	public static final String MSG_SYSERROR = "系统异常，请稍后重试！";


	public static final BaseRes<String> SYSERROR = new BaseRes<String>(CODE_SYSERROR, MSG_SYSERROR, null);

	public static final BaseRes<String> SUCCESS = new BaseRes<String>(CODE_SUCCESS, MSG_SUCCESS, null);

	public static final BaseRes<String> PARAMERROR = new BaseRes<String>(CODE_PARAM_ERROR, MSG_PARAM_ERROR, null);

	/** 结果编码 */
	private String code = CODE_SUCCESS;

	/** 错误消息 */
	private String message = MSG_SUCCESS;

	/** 数据对象 */
	private T data;

	/** 数据数量 */
	private Integer totalCount;

	public BaseRes() {
		super();
	}

	public BaseRes(String code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public BaseRes(T data) {
		super();
		this.data = data;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
