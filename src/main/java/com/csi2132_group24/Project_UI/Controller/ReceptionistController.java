package com.csi2132_group24.Project_UI.Controller;

import com.csi2132_group24.Project_UI.DTO.Patient;
import com.csi2132_group24.Project_UI.PatientRepository;
import com.csi2132_group24.Project_UI.Security.User;
import com.csi2132_group24.Project_UI.Security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ReceptionistController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PatientRepository patientRepo;

    @GetMapping("/receptionist/adduser")
    public String getAddUser(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("patient", new Patient());
        model.addAttribute("allUsers", userRepo.findAll());
        return "receptionist/addUser";
    }

    @PostMapping("/receptionist/adduser")
    public String postAddUser(@Valid User user, @Valid Patient patient, BindingResult result, Model model){
        if(result.hasErrors()){

            return "oops";
        }
        userRepo.save(user);
        patient.setUser_id(user.getUser_id());
        patientRepo.save(patient);
        return "receptionist/adduser";
    }

}
