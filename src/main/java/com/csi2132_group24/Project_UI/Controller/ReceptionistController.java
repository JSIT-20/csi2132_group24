package com.csi2132_group24.Project_UI.Controller;

import com.csi2132_group24.Project_UI.DTO.Patient;
import com.csi2132_group24.Project_UI.Repository.PatientRepository;
import com.csi2132_group24.Project_UI.Security.User;
import com.csi2132_group24.Project_UI.Security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ReceptionistController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PatientRepository patientRepo;

    @GetMapping("/receptionist/addpatient")
    public String getAddPatient(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("patient", new Patient());
        model.addAttribute("allUsers", userRepo.findAll());
        return "receptionist/addPatient";
    }

    @GetMapping("/receptionist/editpatient")
    public String getEditPatient(Model model){
        model.addAttribute("patients", userRepo.findAllPatientUsers());
        return "receptionist/editPatient";
    }

    @GetMapping("/receptionist/editpatient/{id}")
    public String getEditPatientForm(@PathVariable("id") Integer id, Model model){
        User user = userRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        model.addAttribute("patient", patientRepo.findById(id));
        return "receptionist/editPatientForm";
    }

    @PostMapping("/receptionist/editpatient/{id}")
    public String updatePatient(@PathVariable("id") Integer id, @Valid User user, @Valid Patient patient, BindingResult result, Model model){
        if(result.hasErrors()){
            return "redirect:/receptionist/editpatient/" + id;
        }
        user.setUser_id(id);
        patient.setUser_id(id);
        userRepo.save(user);
        patientRepo.save(patient);
        return "redirect:/receptionist/editpatient";
    }

    @PostMapping("/receptionist/addpatient")
    public String postAddUser(@Valid User user, @Valid Patient patient, BindingResult result, Model model){
        if(result.hasErrors()){

            return "oops";
        }
        userRepo.save(user);
        patient.setUser_id(user.getUser_id());
        patientRepo.save(patient);
        return "receptionist/addpatient";
    }

}
