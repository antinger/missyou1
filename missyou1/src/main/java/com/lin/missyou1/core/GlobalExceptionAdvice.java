package com.lin.missyou1.core;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.lin.missyou1.core.configuration.ExceptionCodeConfiguration;
import com.lin.missyou1.exception.http.HttpException;
/*
 * 全局异常处理类，标记注解，可以自动接收所有抛出的异常进行处理
 */
@ControllerAdvice
public class GlobalExceptionAdvice {
	
	@Autowired
	private ExceptionCodeConfiguration codeConfiguration;
	
	//处理未知异常
	@ExceptionHandler(value=Exception.class)
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public UnifyResponse handleExpection(HttpServletRequest request, Exception e) {
		String requestUrl = request.getRequestURI();
		String method = request.getMethod();
		UnifyResponse message = new UnifyResponse(9999, "找不到", method + ":" + requestUrl);
		return message;
	}
	
	//自定义异常处理
	@ExceptionHandler(HttpException.class)
	public ResponseEntity<UnifyResponse> handleHttpExpection(HttpServletRequest request, HttpException e) {
		String requestUrl = request.getRequestURI();
		String method = request.getMethod();
		UnifyResponse message = new UnifyResponse(e.getCode(), codeConfiguration.getMessage(e.getCode()), method + ":" + requestUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpStatus httpStatus = HttpStatus.resolve(e.getHttpStatusCode());
		ResponseEntity<UnifyResponse> entity = new ResponseEntity<UnifyResponse>(message, headers, httpStatus);
		return entity;
	}
	
	//自定义验证器的异常信息
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ResponseBody
	public UnifyResponse handleBeanValidtion(HttpServletRequest request, MethodArgumentNotValidException e) {
		String requestUrl = request.getRequestURI();
		String method = request.getMethod();
		List<ObjectError> errors = e.getBindingResult().getAllErrors();
		String message = formatAllErrorsMessages(errors);
		return new UnifyResponse(10001, message, method + ":" + requestUrl);
	}
	
	//原生验证器的异常信息
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ResponseBody
	public UnifyResponse handleConstraintException(HttpServletRequest request, ConstraintViolationException e) {
		String requestUrl = request.getRequestURI();
		String method = request.getMethod();
		
		String message = e.getMessage();
		return new UnifyResponse(10001, message, method + ":" + requestUrl);
	}

	//拼接异常信息
	private String formatAllErrorsMessages(List<ObjectError> errors) {
		StringBuffer message = new StringBuffer();
		for (ObjectError e : errors) {
			message.append(e.getDefaultMessage()).append(";");
		}
		return message.toString();
	}

}
