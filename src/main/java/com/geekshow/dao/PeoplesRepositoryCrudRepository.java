package com.geekshow.dao;

import org.springframework.data.repository.CrudRepository;

import com.geekshow.pojo.Peoples;

/**
 * CrudRepository接口
 * @author xiaozhijun
 *
 */
public interface PeoplesRepositoryCrudRepository extends CrudRepository<Peoples, Integer> {

}
