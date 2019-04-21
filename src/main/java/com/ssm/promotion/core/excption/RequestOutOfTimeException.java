package com.ssm.promotion.core.excption;

public class RequestOutOfTimeException extends RuntimeException{
	
	public RequestOutOfTimeException() {
		super("密码输入错误超过次数");
	}
}
