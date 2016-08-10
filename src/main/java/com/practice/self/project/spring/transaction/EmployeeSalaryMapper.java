package com.practice.self.project.spring.transaction;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeSalaryMapper implements RowMapper<EmployeeSalary> {

	@Override
	public EmployeeSalary mapRow(ResultSet rs, int i)
			throws SQLException {
		EmployeeSalary es = new EmployeeSalary();
		es.setId(rs.getInt(1));
		es.setName(rs.getString(2));
		es.setDepartment(rs.getString(3));
		es.setSid(rs.getInt(4));
		es.setSalary(rs.getInt(5));
		es.setYear(rs.getInt(6));
		return es;
	}
	
}
