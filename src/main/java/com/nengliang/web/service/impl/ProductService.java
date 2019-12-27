package com.nengliang.web.service.impl;

import java.util.List;

import com.github.pagehelper.PageRowBounds;
import com.nengliang.web.dto.ProductDTO;
import com.nengliang.web.entity.Product;

public interface ProductService {

	// 新增商品
	ProductDTO save(ProductDTO productDTO);

	// 更新商品
	ProductDTO updateByOne(ProductDTO productDTO);

	// 根据ID查询商品
	Product findById(Integer id);

	// 删除商品
	void deleteById(Integer id);

	// 查询商品名字
	String findByName(String productName);

	// 查询商品并分页
	List<ProductDTO> findList(PageRowBounds rowBounds);

}
