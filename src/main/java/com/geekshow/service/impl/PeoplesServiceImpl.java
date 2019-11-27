package com.geekshow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.geekshow.dao.PeoplesRepository;
import com.geekshow.pojo.Peoples;
import com.geekshow.service.PeoplesService;

@Service
public class PeoplesServiceImpl implements PeoplesService {
	
	@Autowired
	private PeoplesRepository peoplesRepository;

	@Override
	@Cacheable(value="peoples")
	public List<Peoples> findPeoplesAll() {
		return peoplesRepository.findAll();
	}

	@Override
	//@Cacheable:对当前查询的对象做缓存处理
	@Cacheable(value="peoples")
	public Peoples findPeoplesById(Integer id) {
		return peoplesRepository.findOne(id);
	}

	@Override
	@Cacheable(value="peoples",key="#pageable.pageSize")
	public Page<Peoples> findPeoplesByPage(Pageable pageable) {
		return peoplesRepository.findAll(pageable);
	}

	@Override
	//@CacheEvict(value="users",allEntries=true) 清除缓存中以users缓存策略缓存的对象
	@CacheEvict(value="peoples",allEntries=true)
	public void savePeoples(Peoples peoples) {
		peoplesRepository.save(peoples);
	}


}
