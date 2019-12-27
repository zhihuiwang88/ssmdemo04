package com.nengliang.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.crypto.Data;



@lombok.Data
public class Product implements Serializable{
	
	/**
	 * 商品实体类
	 */
	private static final long serialVersionUID = -4794486944445717669L;
	
	private Integer id;
	private String productName;
	private Integer productAmount;
	private Integer productStatus;
	private BigDecimal productPrice;
	private Data createTime;
	private Data updateTime;
	
	
	
	
}
