package com.jsp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jsp.model.User;

@Repository
public interface UserRepo  extends CrudRepository<User, Integer>{

}
