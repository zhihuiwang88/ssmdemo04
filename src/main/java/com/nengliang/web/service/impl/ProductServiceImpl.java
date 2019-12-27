package com.nengliang.web.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageRowBounds;
import com.nengliang.web.dao.ProductMapper;
import com.nengliang.web.dto.ProductDTO;
import com.nengliang.web.entity.Product;
import com.nengliang.web.enums.ProductStatusEnum;
import com.nengliang.web.enums.ResultEnum;
import com.nengliang.web.exception.ProductException;
import com.nengliang.web.verification.DataVerification;

@Service
public class ProductServiceImpl implements ProductService {

	/**
	 * 实现类不用tyr{}catch(){},实现类出现异常Controller层直接捕获并处理了
	 * 
	 */

	@Autowired
	private ProductMapper productMapper;

	private static final Log log = LogFactory.getLog(ProductServiceImpl.class);

	// 更新一个商品
	@Override
	public ProductDTO updateByOne(ProductDTO productDTO) {
		// 判断参数符合格式不
		DataVerification.verification(productDTO);
		// 判断商品名称重复不
		String productName = productMapper.findByName(productDTO.getProductName());
		if (productName != null) {
			log.error("【更新商品】，商品名称重复");
			throw new ProductException(ResultEnum.PRODUCT_NAME_ERROR);
		} else {
			Product product = new Product();
			BeanUtils.copyProperties(productDTO, product);
			productMapper.updateByOne(product);
		}
		return productDTO;
	}

	@Override
	public Product findById(Integer id) {
		Product product = productMapper.findById(id);
		return product;
	}

	@Override
	public void deleteById(Integer id) {
		Product product = productMapper.findById(id);
		// 判断ID
		if (product == null) {
			log.error("【删除商品】，商品不存在");
			throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
		}
		productMapper.deleteById(id);
	}

	// 新增数据
	public ProductDTO save(ProductDTO productDTO) {

		// 判断参数符合格式不
		DataVerification.verification(productDTO);
		// 判断商品名重复不
		String resultProductDTO = productMapper.findByName(productDTO.getProductName());
		if (resultProductDTO != null) {
			log.info("【新增商品】，商品名称重复");
			throw new ProductException(ResultEnum.PRODUCT_NAME_ERROR);
		} else {
			Product product = new Product();
			BeanUtils.copyProperties(productDTO, product);
			product.setProductStatus(ProductStatusEnum.PRODUCT_STATUS_DOWN.getCode());
			productMapper.save(product);
		}
		return productDTO;
	}

	@Override
	public String findByName(String productName) {
		return productMapper.findByName(productName);
	}

	@Override
	public List<ProductDTO> findList(PageRowBounds rowBounds) {
		List<ProductDTO> list = productMapper.findList(rowBounds);
		return list;
	}

}
