package com.msp.mybatis.bean.helloworld;

public interface EmployeeMapper {

	public Employee getEmployeeById(Integer id);
	public Boolean addEmployee(Employee emp);
	public Boolean deleteEmployeeById(Integer id);
	public Integer updateEmployer(Employee emp);
}
