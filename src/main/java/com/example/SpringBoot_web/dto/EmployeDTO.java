package com.example.SpringBoot_web.dto;

import com.example.SpringBoot_web.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmployeDTO {

    private Long id;


    @NotNull(message = "Name can't be null")
    //@NotEmpty(message = "Name can't be Empty")
    @Size(min = 3,max = 10,message = "Name should lie btw the given range [3,10]")
    private String name;


    @Email(message = "Email should be in form of ...@gmail.com")
    private String email;

    @Max(value = 80,message = "Age of Employee not be greater then 80")
    @Min(value = 18,message = "Age of employee can't be less then 18")
    private Integer age;

    @PastOrPresent(message = "Date of joining of employee should not be in future")
    private LocalDate dateofjoining;

    @NotBlank(message = "Role of the employee not be blank")
    //@Pattern(regexp = "^(ADMIN|USER)$",message = "Role of Employee can be ADMIN or USER ")
    @EmployeeRoleValidation
    private String role; //ADMIN/USER

    @NotNull(message = "Salary of Employee can't be null")
    @Positive(message = "Salary of employee should be positive")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    private Integer salary;

    @AssertTrue(message = "Employee should be Active")
    private boolean isActive;
}
