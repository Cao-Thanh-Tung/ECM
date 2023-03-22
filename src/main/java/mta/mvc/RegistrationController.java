package mta.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/registration")
    public String reg(Map<String, Object> model) {
        model.put("employee", new Employee ());
        return "views/Registration";
    }

    @PostMapping("/home")
    public String createEmployee(@ModelAttribute("employee") Employee  emp ) {
        employeeService.createOrUpdateEmployee(emp);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String listOfEmployee(Model model) {
        List<Employee> employeeList = employeeService.getAllEmployee();
        model.addAttribute("empList", employeeList);
        return "views/employeeList";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam("id") String id) {
        employeeService.deleteEmployee(Long.parseLong(id));
        return "redirect:/list";
    }

    @GetMapping("/edit")
    public String editEmployee(@RequestParam("id") String id, Map<String, Object> model) {
        Employee  emp= employeeService.editEmployee(Long.parseLong(id));
        model.put("employee", emp );
        return "views/Registration";
    }

    //=============ResponseBody, RequestBody ================================
    //http://localhost:8081/getById?id=2
    @GetMapping("/getById")
    public @ResponseBody
    Employee  getEmpById(@RequestParam("id") String id) {
        Employee emp= new Employee();
        emp=employeeService.getEmployee(Long.parseLong(id));

        return emp;//employeeService.getEmployee(Long.parseLong(id));
    }
    //    Chạy trên postman để thấy trạng thái
    //    http://localhost:8081/getById2?id=2
    @GetMapping("/getById2")
    public ResponseEntity<Employee > getEmpById2(@RequestParam("id") String id) {
        Employee  emp1=new Employee ();
        emp1 = employeeService.getEmployee(Long.parseLong(id));
        //  emp1=null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "foo - Department");

        if (emp1==null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(emp1);
    }

// EmployeeDTO create(@RequestBody MultiValueMap body )
// Chạy: Chạy view => form; nhập dữ liệu từ form => gọi addNew
// http://localhost:8081/regRequestBody
    @PostMapping(value = "/addNew")
    public @ResponseBody    Employee  create( Employee  emp  ) {
        employeeService.createOrUpdateEmployee(emp) ;
        return emp ;
    }
    @GetMapping("/regRequestBody")
    public String regRequestBody(Map<String, Object> model) {
        model.put("employee", new Employee ());
        return "views/Registration_RequestBody";
    }
// End
    //Chạy trên post man
    /* http://localhost:8081/addNewPostMan
        { "firstName":"dsds","lastName":"dsdsds","userName":"dsdsdsds"
        ,"emailId":"maAA_KK@ma.edu","empId":"12","bloodGp":"A","age":10
        ,"personalEmail":"","mobileNo":""
        }
    */
    @PostMapping(value = "/addNewPostMan",produces = "application/json;charset=UTF-8")
    public @ResponseBody
    Employee  createPostMan(@RequestBody Employee  emp  ) {
        employeeService.createOrUpdateEmployee(emp );
        return emp;
    }
    // End - Chạy trên post man
}
