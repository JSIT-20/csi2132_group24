package com.csi2132_group24.Project_UI.Controller;

import com.csi2132_group24.Project_UI.DTO.Appointment;
import com.csi2132_group24.Project_UI.Repository.AppointmentRepository;
import com.csi2132_group24.Project_UI.Repository.RecordRepository;
import com.csi2132_group24.Project_UI.Security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PatientController {

    @Autowired
    private AppointmentRepository appointmentRepo;

    @Autowired
    private RecordRepository recordRepo;

    @GetMapping("/patient/appointments")
    public String getAppointmentsPatient(Model model){
        CustomUserDetails user = getLoggedInUser();
        model.addAttribute("appointments", appointmentRepo.findAllAppointmentsForPatient(user.getUser_id()));
        return "/patient/appointments";
    }

    @GetMapping("/patient/records")
    public String getRecordsPatient(Model model){
        CustomUserDetails user = getLoggedInUser();
        model.addAttribute("records", recordRepo.findAllRecordsForPatient(user.getUser_id()));
        return "/patient/records";
    }

    public CustomUserDetails getLoggedInUser(){
        return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
