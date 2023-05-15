package br.com.MeloExpress.Employees.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

public record EmployeeCreateDTO(
        UUID employeeCode,
        String name,
        String cpf,
        String rg,
        String cnh,
        String birth,
        String gender,
        String occupation,
        String zipcode,
        String street,
        String number,
        String neighborhood,
        String city,
        String state,
        String country,
        boolean active
) {
    public EmployeeCreateDTO(
            UUID employeeCode,
            String name,
            String cpf,
            String rg,
            String cnh,
            String birth,
            String gender,
            String occupation,
            String zipCode,
            String street,
            String number,
            String neighborhood,
            String city,
            String state,
            String country
    ) {
        this(employeeCode, name, cpf, rg, cnh, LocalDateTime.parse(birth, DateTimeFormatter.ofPattern("dd-MM-yyyy")).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), gender, occupation, zipCode, street, number, neighborhood, city, state, country, true);
    }
}

