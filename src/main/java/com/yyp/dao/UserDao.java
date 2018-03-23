package com.yyp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yyp.model.User;

@Repository
@Transactional
public interface UserDao extends JpaRepository<User, Integer> {
	//根据方法名自动构造查询语句
	User findByNameLike(String name);
	//根据自定义查询语句进行查询，使用hql语句
	@Query("select u from User u where u.password like ?1 ")
	User findByPassword(String password);
	//根据原始sql语句进行查询
	@Query(value="select * from user where username like ?1 ",nativeQuery=true)
	User findByUsernameNativeQuery(String userName);
	//更新用户信息
	
	@Query(value="update User u SET u.username='admin' where u.id= ?1",nativeQuery=true)
	@Modifying
	int UpdateUsesrName(int id);
}
