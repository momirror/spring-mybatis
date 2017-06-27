package com.msp.mybatis.bean.helloworld;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MybatisTest {
	
	public SqlSessionFactory getSessionFactory() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
	
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		return sqlSessionFactory;
	}

	/*
	 *根据xml文件创建SqlSessionFactory 
	 */
	//@Test
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
	
//	@Test
	public void testInterfaceSelect() throws IOException {
		SqlSessionFactory factory = getSessionFactory();
		SqlSession openSession = factory.openSession();
		EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
		
		//查询
		Employee employee = mapper.getEmployeeById(1);
		System.out.println(employee);
		
	}
	
//	@Test
	public void testInterfaceAdd() throws IOException {
		SqlSessionFactory factory = getSessionFactory();
		SqlSession openSession = factory.openSession();
		
		try{
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			Employee employee = new Employee("xiaohong", "xiaohong@test.com", "f");
			mapper.addEmployee(employee);
			openSession.commit();//commit之后才会生效
		}finally{
			openSession.close();
		}
		
	}
	
	
	//@Test
	public void testInterfaceUpdate() throws IOException {
		SqlSessionFactory factory = getSessionFactory();
		SqlSession openSession = factory.openSession();
		
		try{
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			Employee employee = new Employee(6,"xiaoyu", "xiaoyu@test.com", "f");
			mapper.updateEmployer(employee);
			openSession.commit();//commit之后才会生效
		}finally{
			openSession.close();
		}
		
	}
	
	@Test
	public void testInterfaceDelete() throws IOException {
		SqlSessionFactory factory = getSessionFactory();
		SqlSession openSession = factory.openSession();
		
		try{
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			mapper.deleteEmployeeById(5);
			openSession.commit();//commit之后才会生效
		}finally{
			openSession.close();
		}
		
	}

}
