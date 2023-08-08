package Ima.Salgado.Empleados02.model;

import Ima.Salgado.Empleados02.model.EmployeeRepository;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private EmployeeRepository employeeRepository;

    public DataLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;


        employeeRepository.save(new Employee("Juan", "Perez"));
        employeeRepository.save(new Employee("Gabriel", "Gerez"));
        employeeRepository.save(new Employee("Ana", "Gonzalez"));
        employeeRepository.save(new Employee("Florencia", "Leon"));
        employeeRepository.save(new Employee("Silvana", "Acosta"));

    }


}
