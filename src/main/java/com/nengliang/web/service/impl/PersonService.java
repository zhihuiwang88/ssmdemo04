package com.nengliang.web.service.impl;

import java.util.List;

import com.nengliang.web.entity.Person;

public interface PersonService {
	
	List<Person> showPageLimit(Integer pageNum,  Integer pageSize);

	List<Person> findParam();






}
