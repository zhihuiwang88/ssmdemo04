package com.nengliang.web.service.impl;

/**
 * 用户表的CRUD
 * @author Dell
 * @Data 2019/06/18
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nengliang.web.dao.PersonMapper;
import com.nengliang.web.entity.Person;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonMapper perMapper;

	/*对所有数据进行分页显示
	 * @Param pageNum：第几页开始，pageSize：每页显示多少条数据
	 * 
	 */
	public List<Person> showPageLimit(Integer pageNum,  Integer pageSize) {
		List<Person> list =	perMapper.showPageLimit(pageNum,pageSize);
		return list;
	}
	
	/*
	 * 查询出数据库所有的数据
	 */
	public List<Person> findParam() {
		List<Person> list =	perMapper.findParam();
		return list;
	}



	





	
	
	
}
