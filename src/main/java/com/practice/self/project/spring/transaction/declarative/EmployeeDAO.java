package com.practice.self.project.spring.transaction.declarative;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;

import com.practice.self.project.spring.transaction.EmployeeSalary;

public interface EmployeeDAO {

	public void setDataSource(DataSource dataSource);
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate);
	
	public void insert(EmployeeSalary employeeSalary);

	public List<EmployeeSalary> list();
}
