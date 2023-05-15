package br.com.MeloExpress.Employees.Controller;

import br.com.MeloExpress.Employees.DTO.EmployeeCreateDTO;
import br.com.MeloExpress.Employees.DTO.EmployeeDetailsDTO;
import br.com.MeloExpress.Employees.Domain.Employees;
import br.com.MeloExpress.Employees.Exceptions.EmployeeNotFoundException;
import br.com.MeloExpress.Employees.Service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    private final EmployeeService employeesService;

    public EmployeesController(EmployeeService employeesService) {
        this.employeesService = employeesService;
    }

    @PostMapping
    public ResponseEntity<Employees> createEmployee(@RequestBody EmployeeCreateDTO employeeCreateDTO) {
        Employees newEmployee = employeesService.createEmployee(employeeCreateDTO);
        return ResponseEntity.created(URI.create("/employees/" + newEmployee.getId())).body(newEmployee);
    }

    @GetMapping("/code/{employeeCode}")
    public ResponseEntity<EmployeeDetailsDTO> getEmployeeDetails(@PathVariable UUID employeeCode) {
        try {
            EmployeeDetailsDTO employeeDetailsDTO = employeesService.getEmployeeDetails(employeeCode);
            return ResponseEntity.ok(employeeDetailsDTO);
        } catch (EmployeeNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }



}

