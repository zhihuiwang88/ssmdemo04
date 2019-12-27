package com.nengliang.web.serviceimpl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageRowBounds;
import com.nengliang.web.dao.ProductMapper;
import com.nengliang.web.dto.ProductDTO;
import com.nengliang.web.entity.Product;
import com.nengliang.web.service.impl.ProductService;
import com.nengliang.web.service.impl.ProductServiceImpl;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:mybatis-spring.xml")
public class ProductServiceImplTest {

	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@Autowired
	private  ProductMapper productMapper;
	
	private static final Log log = LogFactory.getLog(ProductServiceImpl.class);

	


	@Test
	public void findList() throws Exception {
		

	}

	@Test
	public void updateByOne() {

		Product product = new Product();
		ProductDTO productDTO = new ProductDTO();
		product.setId(63);
		product.setProductName("油条12");
		product.setProductAmount(100);
		product.setProductStatus(1);
		product.setProductPrice(new BigDecimal(100));
		BeanUtils.copyProperties(product, productDTO);
		productServiceImpl.updateByOne(productDTO);
		log.info("==更新一个商品==");
	}

	@Test
	public void save() throws Exception {
		Product product = new Product();
		ProductDTO productDTO = new ProductDTO();
		product.setProductName("油条6");
		product.setProductAmount(4);
		product.setProductStatus(1);
		product.setProductPrice(new BigDecimal(0.03));
		BeanUtils.copyProperties(product, productDTO);
		productServiceImpl.save(productDTO);
		log.info("==新增==");
	}

	@Test
	public void delete() throws Exception {
		Integer id = 27;
		productServiceImpl.findById(id);
		productServiceImpl.deleteById(id);
		log.info("==删除==");
	}



}
