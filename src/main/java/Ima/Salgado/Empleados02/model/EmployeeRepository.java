package Ima.Salgado.Empleados02.model;

import Ima.Salgado.Empleados02.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
