package com.nengliang.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageRowBounds;
import com.nengliang.web.dao.ProductMapper;
import com.nengliang.web.dto.ProductDTO;
import com.nengliang.web.entity.Product;
import com.nengliang.web.enums.ResultEnum;
import com.nengliang.web.exception.ProductException;
import com.nengliang.web.service.impl.ProductService;
import com.nengliang.web.service.impl.ProductServiceImpl;
import com.nengliang.web.util.ResultVOUtil;
import com.nengliang.web.vo.ResultVO;

@RestController
@RequestMapping("/product")
public class ProductController {

	
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductMapper  productMapper;
	
	private static final Log log = LogFactory.getLog(ProductServiceImpl.class);
	
	/**
	 * http://localhost:8081/mvcmybatis03/product/add
	 * 新增商品
	 * productStatus默认0是下架
	 * @param productThreeDTO
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	@PostMapping("/add")
	public ResultVO save(@RequestBody ProductDTO productDTO) {
		// 判断参数为空
		//判断新增
		try {
			ProductDTO resultProduct = productService.save(productDTO);
		} catch (Exception e) {
           return ResultVOUtil.error(ResultEnum.ERROR);
		}
		return ResultVOUtil.succeed();
	}

	/**
	 * http://localhost:8081/mvcmybatis03/product/updateByOne
	 * 更新一个商品
	 * @param productThreeDTO
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PutMapping("/updateByOne")
	public ResultVO<ProductDTO> updateByone(@RequestBody ProductDTO productDTO) {
		try {
			Product  product = productService.findById(productDTO.getId());
			//判断ID
			if(product == null) {
				throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
			}
			// 更新一个商品
			productService.updateByOne(productDTO);
		} catch (Exception e) {
			return ResultVOUtil.error(ResultEnum.ERROR);
		}
		return ResultVOUtil.succeed();
	}
	
	
	/**
	 * https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/en/HowToUse.md
	 * http://localhost:8081/mvcmybatis03/product/findList?pageNum=1&pageSize=3
	 * 根据商品名和商品状态查
	 * @param pageNum，从第几页开始
	 * @param pageSize，每页显示几条数据
	 * @param productTwoDTO
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/findList")
	public ResultVO<ProductDTO> find(@RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			PageRowBounds rowBounds = new PageRowBounds(pageNum, pageSize);
			List<ProductDTO> resultList = productService.findList(rowBounds);
			long total = rowBounds.getTotal();
			 map.put("pageNum",  pageNum);
			 map.put("pageSize", pageSize);
			 map.put("total",total);
			 map.put("product",resultList);
			 
		} catch (Exception e) {
			return ResultVOUtil.error(ResultEnum.ERROR);
		}
		return ResultVOUtil.succeed(map);	
	}
	
	
	
	
	/**
	 * http://localhost:8081/mvcmybatis03/product/remove/11
	 * 删除商品
	 * @param id，商品ID
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@DeleteMapping("/remove/{id}")
	public ResultVO<Integer> delete(@PathVariable Integer id) {
		
		try {
			//删除商品
			productService.deleteById(id);
		} catch (Exception e) {
			return ResultVOUtil.error(ResultEnum.ERROR);
		}
		return ResultVOUtil.succeed();
	}
	
	
}
