package mta.mvc;


import java.util.List;

public interface EmployeeService {

	public void createOrUpdateEmployee(Employee  emp );

	public List<Employee> getAllEmployee();
	
	public void deleteEmployee(Long id);
	
	public Employee editEmployee(Long id);
	public Employee getEmployee(Long id);
}
