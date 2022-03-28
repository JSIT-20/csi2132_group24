package com.csi2132_group24.Project_UI.Repository;

import com.csi2132_group24.Project_UI.DTO.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
