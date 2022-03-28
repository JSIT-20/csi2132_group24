package com.csi2132_group24.Project_UI.Security;

import com.csi2132_group24.Project_UI.DTO.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(
            value = "SELECT * FROM public.user u WHERE u.email =:email",
            nativeQuery = true)
    public User findByEmail(String email);

    @Query(
           value = "SELECT u.* FROM public.user u, public.patient p WHERE u.user_id = p.user_id",
           nativeQuery = true)
    public List<User> findAllPatientUsers();

}