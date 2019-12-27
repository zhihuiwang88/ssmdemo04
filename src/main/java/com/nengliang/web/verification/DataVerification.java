package com.nengliang.web.verification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.nengliang.web.dto.ProductDTO;
import com.nengliang.web.enums.ResultEnum;
import com.nengliang.web.exception.ProductException;
import com.nengliang.web.util.ResultVOUtil;
import com.nengliang.web.vo.ResultVO;

public class DataVerification {
	
	/**
	 * 商品名和数量和价格校验格式
	 * 数量：非负整数：^\d+$
	 * 单价：正浮点数：^[1-9]\d*\.\d*|0\.\d*[1-9]\d*$
	 * 名字：中文、英文、数字包括下划线：^[\u4E00-\u9FA5A-Za-z0-9_]+$
	 * 三到十：^[\u4E00-\u9FA5A-Za-z0-9_]{3,10}$
	 * @return 
	 */
	private static final Log log = LogFactory.getLog(DataVerification.class);

	@SuppressWarnings("unchecked")
	public static ResultVO<ProductDTO> verification(ProductDTO productDTO) {
		String productName = productDTO.getProductName();
		String productAmount = productDTO.getProductAmount().toString();
		String productPrice = productDTO.getProductPrice().toString();
		String productStatus = productDTO.getProductStatus().toString();
		boolean resutlAmount = false;
		boolean resultPrice = false;
		boolean resultName = false;
		boolean resultStatus = false;
		// 设定正则表达式对参数进行校验
		String amountRegex = "^\\d+$";
		Pattern patternAmount = Pattern.compile(amountRegex);
		Matcher matcherAmount = patternAmount.matcher(productAmount);
		resutlAmount = matcherAmount.matches();
		Matcher matcherStatus = patternAmount.matcher(productStatus);
		resultStatus = matcherStatus.matches();
		if (!resutlAmount) {
			log.error("【正则校验数据】，商品数量格式不正确");
			throw new ProductException(ResultEnum.PRODUCT_AMOUNT_VERIFICATIOIN_ERROR);
		}
		if (!resultStatus) {
			log.error("【正则校验数据】，商品状态格式不正确");
			throw new ProductException(ResultEnum.PRODUCT_STATUS_VERIFICATIOIN_ERROR);
		}
		// 商品单价
		String priceRegex = "^[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*$";
		Pattern patternPrice = Pattern.compile(priceRegex);
		Matcher matcherPrice = patternPrice.matcher(productPrice);
		resultPrice = matcherPrice.matches();
		if (!resultPrice) {
			log.error("【正则校验数据】，商品单价格式不正确");
			throw new ProductException(ResultEnum.PRODUCT_PRICE_VERIFICATIOIN_ERROR);
		}
		// 商品名称 ,"(^[a-zA-Z0-9_-]{5,16}$)|(^[\u2E80-\u9FFF]{2,5})";
		String nameRegex = "^[\u4E00-\u9FA5A-Za-z0-9_]{3,10}$";
		Pattern patternName = Pattern.compile(nameRegex);
		Matcher matcherName = patternName.matcher(productName);
		resultName = matcherName.matches();
		if (!resultName) {
			log.error("【正则校验数据】，商品名称格式不正确");
			throw new ProductException(ResultEnum.PRODUCT_NAME_VERIFICATIOIN_ERROR);
		}
		return ResultVOUtil.succeed();
	}

}
