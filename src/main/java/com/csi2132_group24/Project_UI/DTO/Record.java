package com.csi2132_group24.Project_UI.DTO;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="record")
public class Record {

    @Id
    @Column(name="record_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer record_id;

    @Column(name="notes")
    private String notes;

    @Column(name="user_id")
    private Integer user_id;

    public Integer getRecord_id() {
        return record_id;
    }

    public void setRecord_id(Integer record_id) {
        this.record_id = record_id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
