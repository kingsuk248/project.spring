package com.practice.self.project.spring.transaction.declarative;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.practice.self.project.spring.transaction.EmployeeSalary;
import com.practice.self.project.spring.transaction.EmployeeSalaryMapper;

public class EmployeeJdbcTemplate implements EmployeeDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void insert(EmployeeSalary es) {
		try {
			String SQL1 = "INSERT INTO Employee (name, department) VALUES (?, ?)";
			jdbcTemplate.update(SQL1, es.getName(), es.getDepartment());
			
			String SQL2 = "SELECT MAX(id) FROM Employee";
			int sid = jdbcTemplate.queryForInt(SQL2);
			
			String SQL3 = "INSERT INTO Salary (sid, salary, year) VALUES (?,?,?)";
			jdbcTemplate.update(SQL3, sid, es.getSalary(), es.getYear());
			throw new RuntimeException("A RunTime exception...") ;
		} catch (DataAccessException e) {
			throw e;
		}
	}

	@Override
	public List<EmployeeSalary> list() {
		String SQL = "SELECT * FROM Employee, Salary WHERE Employee.id = Salary.sid";
		List<EmployeeSalary> employeeSalaries = jdbcTemplate.query(SQL, new EmployeeSalaryMapper());
		return employeeSalaries;
	}
}
