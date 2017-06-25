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
	 *����xml�ļ�����SqlSessionFactory 
	 */
	@Test
	public void test() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
	
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		
		try{
		/**
		 *��һ������Ϊһ����xml�����õ�sql��ʶ
		 *�ڶ�������ΪObject���͵Ĳ���
		 **/
			Employee employee = sqlSession.selectOne("com.msp.mybatis.employerMapper.selectEmployee", 1);
			System.out.println(employee);
		}finally{
			sqlSession.close();
		}
	}

}
