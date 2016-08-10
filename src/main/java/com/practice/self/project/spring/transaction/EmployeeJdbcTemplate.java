package com.practice.self.project.spring.transaction;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

public class EmployeeJdbcTemplate implements EmployeeDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private PlatformTransactionManager transactionManager;
	private TransactionDefinition transactionDefinition;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	@Override
	public void setTransactionDefinition(TransactionDefinition transactionDefinition) {
		this.transactionDefinition = transactionDefinition;
	}

	@Override
	public void insert(EmployeeSalary es) {
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
		try {
			String SQL1 = "INSERT INTO Employee (name, department) VALUES (?, ?)";
			jdbcTemplate.update(SQL1, es.getName(), es.getDepartment());
			
			String SQL2 = "SELECT MAX(id) FROM Employee";
			int sid = jdbcTemplate.queryForInt(SQL2);
			
			String SQL3 = "INSERT INTO Salary (sid, salary, year) VALUES (?,?,?)";
			jdbcTemplate.update(SQL3, sid, es.getSalary(), es.getYear());
			transactionManager.commit(transactionStatus);
		} catch (DataAccessException e) {
			transactionManager.rollback(transactionStatus);
		}
	}

	@Override
	public List<EmployeeSalary> list() {
		String SQL = "SELECT * FROM Employee, Salary WHERE Employee.id = Salary.sid";
		List<EmployeeSalary> employeeSalaries = jdbcTemplate.query(SQL, new EmployeeSalaryMapper());
		return employeeSalaries;
	}
}
