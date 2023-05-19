package br.com.MeloExpress.Employees.Service;

import br.com.MeloExpress.Employees.DTO.EmployeeAddressDTO;
import br.com.MeloExpress.Employees.DTO.EmployeeCreateDTO;
import br.com.MeloExpress.Employees.DTO.EmployeeDetailsDTO;
import br.com.MeloExpress.Employees.Domain.Employees;
import br.com.MeloExpress.Employees.Exceptions.EmployeeNotFoundException;
import br.com.MeloExpress.Employees.Repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeesRepository employeesRepository;

    public Employees createEmployee(EmployeeCreateDTO employeeCreateDTO) {
        Employees employee = new Employees();
        employee.setEmployeeCode(UUID.randomUUID());
        employee.setActive(true);
        String cep = employeeCreateDTO.zipcode();
        RestTemplate restTemplate = new RestTemplate();
        String viaCepUrl = "https://viacep.com.br/ws/"+ cep +"/json/";
        EmployeeAddressDTO employeeAddressDTO = restTemplate.getForObject( viaCepUrl, EmployeeAddressDTO.class);

        if(StringUtils.isEmptyOrWhitespace(employeeAddressDTO.logradouro())) {
            employee.setStreet(employeeCreateDTO.street());
        } else {
            employee.setStreet(employeeAddressDTO.logradouro());
        }

        if(StringUtils.isEmptyOrWhitespace(employeeAddressDTO.bairro())) {
            employee.setNeighborhood(employeeCreateDTO.neighborhood());
        } else {
            employee.setNeighborhood(employeeAddressDTO.bairro());
        }

        employee.setZipcode(employeeAddressDTO.cep());
        employee.setCity(employeeAddressDTO.localidade());
        employee.setState(employeeAddressDTO.uf());


        employee.setNumber(employeeCreateDTO.number());
        employee.setName(employeeCreateDTO.name());
        employee.setCpf(employeeCreateDTO.cpf());
        employee.setRg(employeeCreateDTO.rg());
        employee.setCnh(employeeCreateDTO.cnh());
        employee.setBirth(LocalDateTime.parse(employeeCreateDTO.birth()));
        employee.setGender(employeeCreateDTO.gender());
        employee.setOccupation(employeeCreateDTO.occupation());
        employee.setCountry(employeeCreateDTO.country());


        return employeesRepository.save(employee);
    }

    public EmployeeDetailsDTO getEmployeeDetails(UUID employeeCode) throws EmployeeNotFoundException {
        Optional<Employees> employeeOptional = employeesRepository.findByEmployeeCode(employeeCode);
        if (employeeOptional.isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        Employees employee = employeeOptional.get();

        EmployeeDetailsDTO employeeDetailsDTO = new EmployeeDetailsDTO(
                employee.getId(),
                employee.getEmployeeCode(),
                employee.getName(),
                employee.getCpf(),
                employee.getRg(),
                employee.getCnh(),
                employee.getBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                employee.getGender(),
                employee.getOccupation(),
                employee.getZipcode(),
                employee.getStreet(),
                employee.getNumber(),
                employee.getNeighborhood(),
                employee.getCity(),
                employee.getState(),
                employee.getCountry()
        );

        return employeeDetailsDTO;
    }


}