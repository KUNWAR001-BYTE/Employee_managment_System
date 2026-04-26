package com.example.SpringBoot_web.services;

import com.example.SpringBoot_web.dto.EmployeDTO;
import com.example.SpringBoot_web.entities.EmployeEntity;
import com.example.SpringBoot_web.repositories.EmployeeRepositories;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;


import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepositories employeeRepositories;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepositories employeeRepositories, ModelMapper modelMapper) {
        this.employeeRepositories = employeeRepositories;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeDTO>getEmployebyId(Long employeeId) {
//        Optional<EmployeEntity> employeEntity= employeeRepositories.findById(employeeId);
//        return employeEntity.map(employeEntity1 -> modelMapper.map(employeEntity1,EmployeDTO.class));

       return employeeRepositories.findById(employeeId).map(employeEntity -> modelMapper.map(employeEntity,EmployeDTO.class));
    }

    public List<EmployeDTO> findAll() {
        List<EmployeEntity> employeEntities = employeeRepositories.findAll();
       return employeEntities
                .stream()
                .map(employeEntity -> modelMapper.map(employeEntity,EmployeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeDTO createNewEmployee(EmployeDTO inputEmployee) {
        EmployeEntity toSaveEntity=modelMapper.map(inputEmployee, EmployeEntity.class);
        EmployeEntity savedemployeEntity=employeeRepositories.save(toSaveEntity);
        return modelMapper.map(savedemployeEntity,EmployeDTO.class);
    }

    public  EmployeDTO updateEmployebyId(Long employeeId, EmployeDTO employeDTO) {
        EmployeEntity employeEntity=modelMapper.map(employeDTO,EmployeEntity.class);
        employeEntity.setId(employeeId);
        EmployeEntity savedEmployeeEntity=employeeRepositories.save(employeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeDTO.class);
    }

    public boolean isExistByemployeeId(Long employeeId){
        return employeeRepositories.existsById(employeeId);
    }

    public boolean deleteEmployeById(Long employeeId) {
        boolean exists=isExistByemployeeId(employeeId);
        if(!exists)return false;
        employeeRepositories.deleteById(employeeId);
        return true;
    }

    public EmployeDTO updatepartialEmployeeById(Long employeeId, Map<String, Object> updates) {
        boolean exists=isExistByemployeeId(employeeId);
        if(!exists)return null;
        EmployeEntity employeEntity =employeeRepositories.findById(employeeId).get();
        updates.forEach((field,value)->{
            Field fieldToBeUpdated= ReflectionUtils.findField(EmployeEntity.class,field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated,employeEntity,value);
        });
        return modelMapper.map(employeeRepositories.save(employeEntity), EmployeDTO.class);
    }

}
