package com.nengliang.web.enums;

/**
 * 商品默认下架0
 * @author Dell
 *
 */

public enum ProductStatusEnum {

	PRODUCT_STATUS_DOWN(0),
	PRODUCT_STATUS_UP(1),
	;
	
	private Integer code;
	
	ProductStatusEnum(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}
	
	
	
}
