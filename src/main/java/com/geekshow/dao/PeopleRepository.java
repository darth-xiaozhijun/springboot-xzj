package com.geekshow.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geekshow.pojo.People;

public interface PeopleRepository extends JpaRepository<People, Integer> {

}
