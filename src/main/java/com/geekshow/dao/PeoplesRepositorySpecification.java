package com.geekshow.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.geekshow.pojo.Peoples;

/**
 * JpaSpecificationExecutor
 * @author Administrator
 *
 */
public interface PeoplesRepositorySpecification extends JpaRepository<Peoples, Integer>,
		JpaSpecificationExecutor<Peoples> {
	
	

}
