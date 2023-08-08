package Ima.Salgado.Empleados02.controller;


import Ima.Salgado.Empleados02.model.Employee;
import Ima.Salgado.Empleados02.model.EmployeeRepository;
import Ima.Salgado.Empleados02.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

        @Autowired
        private EmployeeRepository employeeRepository;

        @GetMapping
        public List<Employee> getAllEmployee() {
            return employeeRepository.findAll();
        }

        @PostMapping
        public Employee createEmployee(@RequestBody Employee employee) {
            return employeeRepository.save(employee);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
            Employee employee = employeeRepository.findById(id).orElse(null);
            if (employee == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(employee);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedemployee) {
            Employee employee = employeeRepository.findById(id).orElse(null);
            if (employee == null) {
                return ResponseEntity.notFound().build();
            }
            employee.setName(updatedemployee.getName());
            employee.setLastName(updatedemployee.getLastName());

            employeeRepository.save(employee);
            return ResponseEntity.ok(employee);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
            Employee employee = employeeRepository.findById(id).orElse(null);
            if (employee == null) {
                return ResponseEntity.notFound().build();
            }
            employeeRepository.delete(employee);
            return ResponseEntity.noContent().build();
        }

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employees";
    }
}
