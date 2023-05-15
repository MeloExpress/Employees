package br.com.MeloExpress.Employees.Domain;

import br.com.MeloExpress.Employees.DTO.EmployeeCreateDTO;
import jakarta.persistence.*;
import lombok.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "employees")
@Entity(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID employeeCode;

    private String name;

    private String cpf;

    private String rg;

    private String cnh;

    private String gender;

    private String occupation;

    private String zipcode;

    private String street;

    private String number;

    private String neighborhood;

    private String city;

    private String state;

    private String country;

    private boolean active;

    private LocalDateTime birth;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public Employees (EmployeeCreateDTO employeeCreateDTO) {
        this.employeeCode = employeeCreateDTO.employeeCode();
        this.name = employeeCreateDTO.name();
        this.cpf = employeeCreateDTO.cpf();
        this.rg = employeeCreateDTO.rg();
        this.cnh = employeeCreateDTO.cnh();
        this.birth = LocalDateTime.parse(employeeCreateDTO.birth(), formatter);
        this.gender = employeeCreateDTO.gender();
        this.occupation = employeeCreateDTO.occupation();
        this.zipcode = employeeCreateDTO.zipcode();
        this.street = employeeCreateDTO.street();
        this.number = employeeCreateDTO.number();
        this.neighborhood = employeeCreateDTO.neighborhood();
        this.city = employeeCreateDTO.city();
        this.state = employeeCreateDTO.state();
        this.country = employeeCreateDTO.country();
        this.active = true;
    }
}

