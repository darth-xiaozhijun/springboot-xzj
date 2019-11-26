package com.geekshow.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.geekshow.pojo.Peoples;

/**
 * PagingAndSortingRepository接口
 * @author xiaozhijun
 *
 */
public interface PeoplesRepositoryPagingAndSorting extends PagingAndSortingRepository<Peoples, Integer> {

}
