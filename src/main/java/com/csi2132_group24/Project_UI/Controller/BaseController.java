package com.csi2132_group24.Project_UI.Controller;

import com.csi2132_group24.Project_UI.DTO.Employee;
import com.csi2132_group24.Project_UI.DTO.Patient;
import com.csi2132_group24.Project_UI.Repository.EmployeeRepository;
import com.csi2132_group24.Project_UI.Repository.PatientRepository;
import com.csi2132_group24.Project_UI.Security.CustomUserDetails;
import com.csi2132_group24.Project_UI.Security.User;
import com.csi2132_group24.Project_UI.Security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class BaseController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private PatientRepository patientRepo;

    @GetMapping("/roles")
    public String getDefault(Model model){
        CustomUserDetails user = getLoggedInUser();
        Optional<Employee> employee = employeeRepo.findById(user.getUser_id());
        Optional<Patient> patient = patientRepo.findById(user.getUser_id());
        model.addAttribute("isPatient", !patient.isEmpty());
        model.addAttribute("isReceptionist", isReceptionist(employee));
        model.addAttribute("isDentistOrHygienist", isDentistorHygienist(employee));
        return "roles";
    }

    public Boolean isReceptionist(Optional<Employee> employee){
        if(employee.isEmpty()){
            return false;
        }
        else if(employee.get().getRole().equals("Receptionist")){
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean isDentistorHygienist(Optional<Employee> employee){
        if(employee.isEmpty()){
            return false;
        }
        else if(employee.get().getRole().equals("Dentist")||employee.get().getRole().equals("Hygienist")){
            return true;
        }
        else{
            return false;
        }
    }

    public CustomUserDetails getLoggedInUser(){
        return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }


}
