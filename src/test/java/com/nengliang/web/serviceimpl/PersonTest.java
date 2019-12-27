package com.nengliang.web.serviceimpl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.nengliang.web.dao.PersonMapper;
import com.nengliang.web.entity.Person;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:mybatis-spring.xml")
public class PersonTest {
	@Autowired
	private PersonMapper personMapper;

	@Test
	public void findPage() {
		List<Person> list = personMapper.showPageLimit(0, 3);
		Assert.assertNotEquals(0, list.size());
		System.out.println("----:" + list);
	}

}
