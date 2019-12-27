package com.nengliang.web.dto;

import java.math.BigDecimal;

import javax.xml.crypto.Data;

public class ProductDTO {


	private Integer id;
	private String productName;
	private Integer productAmount;
	private Integer productStatus;
	private BigDecimal productPrice;
	private Data createTime;
	private Data updateTime;
	
	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", productName=" + productName + ", productAmount=" + productAmount
				+ ", productStatus=" + productStatus + ", productPrice=" + productPrice + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(Integer productAmount) {
		this.productAmount = productAmount;
	}
	public Integer getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public Data getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Data createTime) {
		this.createTime = createTime;
	}
	public Data getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Data updateTime) {
		this.updateTime = updateTime;
	}
	
	
	
	
}
