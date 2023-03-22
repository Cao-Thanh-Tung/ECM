package mta.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public void createOrUpdateEmployee(Employee  emp ) {
		employeeRepository.save(emp);
	}


	public List<Employee > getAllEmployee() {
		List<Employee> list = employeeRepository.findAll();

		return list;
	}
	
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}
	
	public Employee  editEmployee(Long id) {
		Employee emp = employeeRepository.getOne(id);
		return  emp;
	}

	public Employee  getEmployee(Long id){
		Employee emp = employeeRepository.findById(id).get();
		return  emp;
	}
}
