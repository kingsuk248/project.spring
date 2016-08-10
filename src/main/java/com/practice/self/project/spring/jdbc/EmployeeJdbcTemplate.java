package com.practice.self.project.spring.jdbc;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class EmployeeJdbcTemplate implements EmployeeDAO {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;

	@Override
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}

	@Override
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void setSimpleJdbcCall(SimpleJdbcCall simpleJdbcCall) {
		this.simpleJdbcCall = simpleJdbcCall.withProcedureName("getRecord");
	}

	@Override
	public Employee get(int id) {
		String SQL = "select * from Employees where id = ?";
		Employee employee = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new EmployeeMapper());
		return employee;
	}

	@Override
	public List<Employee> list() {
		String SQL = "select * from Employees";
		List<Employee> employees = jdbcTemplate.query(SQL, new EmployeeMapper());
		return employees;
	}

	@Override
	public void insert(Employee employee) {
		String SQL = "insert into Employees values (?,?,?)";
		int id = employee.getId();
		String name = employee.getName();
		String department = employee.getDepartment();
		jdbcTemplate.update(SQL, id, name, department);
		
	}

	@Override
	public void update(Employee employee) {
		String SQL = "update Employees set name = ?, department = ? where id = ?";
		int id = employee.getId();
		String name = employee.getName();
		String department = employee.getDepartment();
		jdbcTemplate.update(SQL, name, department, id);
	}

	@Override
	public void delete(int id) {
		String SQL = "delete from Employees where id = ?";
		jdbcTemplate.update(SQL, id);
	}

	@Override
	public void truncate() {
		String SQL = "truncate Employees";
		jdbcTemplate.update(SQL);
	}

	@Override
	public Employee getRecord(int id) {
		SqlParameterSource sps = new MapSqlParameterSource().addValue("in_id", id);
		Map<String, Object> out = simpleJdbcCall.execute(sps);
		Employee e = new Employee();
		e.setName((String) out.get("out_name"));
		e.setDepartment((String) out.get("out_department"));
		return e;
	}
}
