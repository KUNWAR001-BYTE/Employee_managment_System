package com.example.SpringBoot_web.controller;

import com.example.SpringBoot_web.dto.EmployeDTO;
import com.example.SpringBoot_web.entities.EmployeEntity;
import com.example.SpringBoot_web.repositories.EmployeeRepositories;
import com.example.SpringBoot_web.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employees")   //* this will handle both get mapping request 
public class Employee_controler {
//    @GetMapping(path = "/getSecretMessage")
//    public String getMySuperSecretMessage(){
//        return "SecretMessage:Fuck you!!!!";
//    }

    //private final EmployeeRepositories employeeRepositories;    //not good for practice

    private final EmployeeService employeeService;

    public Employee_controler(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeDTO> getEmployebyId(@PathVariable Long employeeId){
        Optional<EmployeDTO> employeDTO= employeeService.getEmployebyId(employeeId);
        return employeDTO
                .map(employeDTO1 -> ResponseEntity.ok(employeDTO1))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmployeDTO>> getAllEmploye(@RequestParam(required = false)Integer age,
                                             @RequestParam(required = false)String sortby){
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping
    public ResponseEntity<EmployeDTO> createNewEmployee(@RequestBody @Valid EmployeDTO inputEmployee){
        EmployeDTO savedEmployee=employeeService.createNewEmployee(inputEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeDTO> updateEmployebyId(@RequestBody EmployeDTO employeDTO,@PathVariable Long employeeId){
        return ResponseEntity.ok(employeeService.updateEmployebyId(employeeId, employeDTO));
    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeById(@PathVariable Long employeeId){
       boolean gotDeleted=employeeService.deleteEmployeById(employeeId);
       if (gotDeleted)return ResponseEntity.ok(true);
       return ResponseEntity.notFound().build();
    }

    @PatchMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeDTO> updatepartialEmployeeById(@RequestBody Map<String, Object> updates,
                                                @PathVariable Long employeeId){
        EmployeDTO employeDTO=employeeService.updatepartialEmployeeById(employeeId,updates);
        if (employeDTO==null)return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeDTO);
    }

//****
//    @GetMapping(path = "/employees/{employeeId}")
//    @GetMapping(path = "/{employeeId}")
//    public EmployeDTO getEmployebyId(@PathVariable Long employeeId){
//        return new EmployeDTO(employeeId,"Raj","rajrai5915@gmail.com",20, LocalDate.of(2023,02,27),true);
//    }





    //@GetMapping(path = "/employees")
//    @GetMapping
//    public String getAllEmploye(@RequestParam(required = false)Integer age,
//                              @RequestParam(required = false)String sortby){
//   return "Hii My  Age is "+age+" "+sortby;
//    }

//    @PostMapping
//    public String createnewEmploye(){
//        return "hello from my  Post Side";
//    }

}
