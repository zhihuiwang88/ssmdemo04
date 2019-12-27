package com.nengliang.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nengliang.web.entity.Person;
import com.nengliang.web.service.impl.PersonService;
import com.nengliang.web.util.JsonResult;

/**
 * 实现用户的CRUD
 * 
 * @author Dell
 * @Data 2019/12/03
 */

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService perService;

	/*
	 * 查询所有数据库的数据,并进行分页显示
	 * http://localhost:8081/mvcmybatis03/person/list
	 * @Param page:第几页， limit:每页显示多少条数据
	 */
	@RequestMapping(value = "/findAllParam",method=RequestMethod.GET)
	@ResponseBody
	public JsonResult selectParam(@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="limit",required=false) Integer limit) {
			JsonResult result = new JsonResult();
			//第几页
			Integer pageNum = (page-1)*limit;
			java.util.List<Person> listShowPage = perService.showPageLimit(pageNum,limit);
			java.util.List<Person> list = perService.findParam();
			result.setCount(list.size());
			result.setCode(0);
			result.setData(listShowPage);
			return result;
	}
	
	/*
	 * 返回list页面
	 */
	@RequestMapping("/list")
	public String strList() {
		return "list";
	}

	
	
	
	
	
	
	
}
