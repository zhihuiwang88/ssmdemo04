package com.nengliang.web.vo;

import lombok.Data;

@Data
public class ResultVO<T> {

	/**
	 * 返回前端页面信息
	 * 
	 */
	
	private Integer code;
	private String message;
	private T data;


	
}
