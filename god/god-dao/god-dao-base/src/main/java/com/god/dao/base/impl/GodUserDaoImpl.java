package com.god.dao.base.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.god.dao.base.IGodUserDao;
import com.god.domain.base.GodUser;

/**
 * GodUser Dao 实现
 * @author H__D
 * @date 2018-12-08 11:36:05
 *
 */
@Repository
public class GodUserDaoImpl implements IGodUserDao{
	
	

	public static void main(String[] args) throws IOException {
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		GodUser godUser = (GodUser) session.selectOne("god.mybatis.base.GodUserMapper.selectGodUser", 1);
		System.out.println(godUser);
		
	}
	
}
