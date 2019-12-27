package com.nengliang.web.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
	
	
	SUCCEED(200,"成功"),
	ERROR(100,"失败"),
	PRODUCT_NAME_VERIFICATIOIN_ERROR(101,"商品名不符合格式"),
	PRODUCT_PRICE_VERIFICATIOIN_ERROR(102,"商品单价不符合格式"),
	PRODUCT_AMOUNT_VERIFICATIOIN_ERROR(103,"商品数量不符合格式"),
	PRODUCT_STATUS_VERIFICATIOIN_ERROR(104,"商品状态不符合格式"),
	PRODUCT_ADD_ERROR(105,"新增商品失败"),
	PRODUCT_NAME_ERROR(106,"商品名称重复"),
	PRODUCT_NOT_EXIST(107,"商品不存在"),
	;
	
	private Integer code;
	private String message;
	
	ResultEnum(Integer code,String message) {
		this.code = code;
		this.message = message;
	}

	

}
