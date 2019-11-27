package com.geekshow.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geekshow.pojo.Parts;

/**
 * 多对多关联关系讲解
 * @author xiaozhijun
 *
 */
public interface PartsRepository extends JpaRepository<Parts, Integer> {

}
