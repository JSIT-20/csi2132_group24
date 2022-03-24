package com.csi2132_group24.Project_UI.Security;

import com.csi2132_group24.Project_UI.DTO.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(
            value = "SELECT * FROM public.user u WHERE u.email =:email",
            nativeQuery = true)
    public User findByEmail(String email);

}