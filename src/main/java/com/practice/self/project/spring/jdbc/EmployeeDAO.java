package com.practice.self.project.spring.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public interface EmployeeDAO {
	
	public void setDataSource(DataSource dataSource);
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate);
	
	public void setSimpleJdbcCall(SimpleJdbcCall simpleJdbcCall);
	
	public Employee get(int id);
	
	public List<Employee> list();
	
	public void insert(Employee employee);
	
	public void update(Employee employee);
	
	public void delete(int id);
	
	public void truncate();
	
	public Employee getRecord(int id);
}
