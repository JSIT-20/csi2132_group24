package com.csi2132_group24.Project_UI.Repository;

import com.csi2132_group24.Project_UI.DTO.Appointment;
import com.csi2132_group24.Project_UI.Security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    @Query(
            value = "SELECT a.* FROM public.appointment a WHERE patient_id=:user_id",
            nativeQuery = true)
    public List<Appointment> findAllAppointmentsForPatient(Integer user_id);
}
