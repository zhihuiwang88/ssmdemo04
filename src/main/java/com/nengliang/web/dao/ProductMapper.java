package com.nengliang.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageRowBounds;
import com.nengliang.web.dto.ProductDTO;
import com.nengliang.web.entity.Product;

public interface ProductMapper extends Mapper{

	Product findById(Integer id);

	void deleteById(Integer id);

	String findByName(String productName);

	void updateByOne(Product product);

	void save(Product product);

	List<ProductDTO> findList(PageRowBounds rowBounds);

}
