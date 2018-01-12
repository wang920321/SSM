package com.yb2g.ssm.exception;

/**
 * 
 * @ClassName: CustomException
 * @Description: 系统自定义的异常类型，实际开发中可能要定义多种异常类型
 * @author: Administrator
 * @date: 2017年12月6日 下午5:04:37
 */
public class CustomException extends Exception {

	/**
	 * 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 异常信息
	private String message;

	public CustomException(String message) {
		super(message);
		this.message = message;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
