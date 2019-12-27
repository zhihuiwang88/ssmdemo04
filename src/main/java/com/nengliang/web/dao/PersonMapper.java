package com.nengliang.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.nengliang.web.entity.Person;

public interface PersonMapper {


	List<Person> showPageLimit(@Param("pageNum") Integer pageNum,  @Param("pageSize") Integer pageSize);

	List<Person> findParam();



}
