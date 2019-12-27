package com.nengliang.web.exception;

import com.nengliang.web.enums.ResultEnum;

public class ProductException extends RuntimeException{
	
	  /**
	 * 异常处理
	 */
	private static final long serialVersionUID = -510345389781837452L;

	private Integer code;
	public  ProductException(ResultEnum resultEnum) {
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
	}

	public Integer getCode() {
		return code;
	}
	
}
