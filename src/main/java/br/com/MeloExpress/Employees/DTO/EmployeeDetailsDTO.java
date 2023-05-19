package br.com.MeloExpress.Employees.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public record EmployeeDetailsDTO(
        Long id,
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
    public EmployeeDetailsDTO(
            Long id,
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
        this(id, employeeCode, name, cpf, rg, cnh, birth, gender, occupation, zipCode, street, number, neighborhood, city, state, country, true);
    }
}
