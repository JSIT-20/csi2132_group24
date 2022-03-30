package com.csi2132_group24.Project_UI.Controller;

import com.csi2132_group24.Project_UI.DTO.Appointment;
import com.csi2132_group24.Project_UI.Repository.AppointmentRepository;
import com.csi2132_group24.Project_UI.Repository.RecordRepository;
import com.csi2132_group24.Project_UI.Security.CustomUserDetails;
import com.csi2132_group24.Project_UI.Security.User;
import com.csi2132_group24.Project_UI.Security.UserRepository;
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
public class DentistController {

    @Autowired
    private AppointmentRepository appointmentRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RecordRepository recordRepo;

    @GetMapping("/dentist/appointments")
    public String getAppointmentsDentist(Model model){
        CustomUserDetails user = getLoggedInUser();
        List<Appointment>  appointments = appointmentRepo.findAllAppointmentsForDentist(user.getUser_id());
        model.addAttribute("appointments", appointmentRepo.findAllAppointmentsForDentist(user.getUser_id()));
        return "dentist/appointments";
    }

    @GetMapping("/dentist/appointment/{id}")
    public String getAppointmentDentist(@PathVariable("id") Integer id, Model model){
        Appointment appointment = appointmentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Appointment Id:" + id));

        model.addAttribute("appointment", appointment);
        model.addAttribute("patient", userRepo.findById(appointment.getPatient_id()).get());
        model.addAttribute("records", recordRepo.findAllRecordsForPatient(appointment.getPatient_id()));
        return "dentist/appointment";
    }

    public CustomUserDetails getLoggedInUser(){
        return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
