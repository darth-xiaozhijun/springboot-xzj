package com.geekshow.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.geekshow.pojo.Peoples;

/**
 * Repository   @Query
 * @author xiaozhijun
 *
 */
public interface PeoplesRepositoryQueryAnnotation extends Repository<Peoples, Integer> {

	@Query("from Peoples where name = ?")
	List<Peoples> queryByNameUseHQL(String name);
	
	@Query(value="select * from t_peoples where name = ?",nativeQuery=true)
	List<Peoples> queryByNameUseSQL(String name);
	
	@Query("update Peoples set name  = ? where id  = ?")
	@Modifying //需要执行一个更新操作
	void updatePeoplesNameByIdUseHQL(String name,Integer id);
}
