package com.mapper;

import com.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author YUANBO
 * @create 2019-02-16 21:46
 **/
public interface UserRepository extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User> {
}
