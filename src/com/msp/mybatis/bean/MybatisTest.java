package com.msp.mybatis.bean;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MybatisTest {

	/*
	 *根据xml文件创建SqlSessionFactory 
	 */
	@Test
	public void test() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
	
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		
		try{
		/**
		 *第一个参数为一个在xml中配置的sql标识
		 *第二个参数为Object类型的参数
		 **/
			Employee employee = sqlSession.selectOne("com.msp.mybatis.employerMapper.selectEmployee", 1);
			System.out.println(employee);
		}finally{
			sqlSession.close();
		}
	}

}
