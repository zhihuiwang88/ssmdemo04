package com.nengliang.web.util;

import com.nengliang.web.enums.ResultEnum;
import com.nengliang.web.vo.ResultVO;

public class ResultVOUtil {

	public static ResultVO succeed(Object object) {
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(200);
		resultVO.setMessage("成功");
		resultVO.setData(object);
		return resultVO;
	}

	public static ResultVO succeed() {
		return succeed(null);
	}

	public static ResultVO error(ResultEnum resultEnum) {
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(resultEnum.getCode());
		resultVO.setMessage(resultEnum.getMessage());
		return resultVO;
	}

}
