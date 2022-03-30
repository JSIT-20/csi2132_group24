package com.csi2132_group24.Project_UI.Repository;

import com.csi2132_group24.Project_UI.DTO.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Integer> {

    @Query(
            value = "SELECT r.* FROM public.record r WHERE user_id=:user_id",
            nativeQuery = true)
    public List<Record> findAllRecordsForPatient(Integer user_id);
}
