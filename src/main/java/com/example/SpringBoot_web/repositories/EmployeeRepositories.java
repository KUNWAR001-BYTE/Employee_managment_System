package com.example.SpringBoot_web.repositories;

import com.example.SpringBoot_web.dto.EmployeDTO;
import com.example.SpringBoot_web.entities.EmployeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface EmployeeRepositories extends JpaRepository<EmployeEntity,Long> {
    List<EmployeEntity>findByName(String name);   // ---->> jpa repository automatically made this method
}
