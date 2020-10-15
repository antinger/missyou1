package com.lin.missyou1.exception.http;

/*
 * 权限异常
 */
public class ForbiddenException extends HttpException {

	public ForbiddenException(int code) {
		this.code = code;
		this.httpStatusCode = 403;
	}
	
}
