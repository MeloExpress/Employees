package br.com.MeloExpress.Employees.Repository;

import br.com.MeloExpress.Employees.Domain.Employees;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {
    Optional<Employees> findByEmployeeCode(UUID employeeCode);
}
