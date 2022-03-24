package com.csi2132_group24.Project_UI;

import com.csi2132_group24.Project_UI.DTO.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
