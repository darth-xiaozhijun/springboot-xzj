package com.geekshow.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.geekshow.pojo.Peoples;

public interface PeoplesService {

	List<Peoples> findPeoplesAll();
	
	Peoples findPeoplesById(Integer id);
	
	Page<Peoples> findPeoplesByPage(Pageable pageable);
	
	void savePeoples(Peoples peoples);
}
