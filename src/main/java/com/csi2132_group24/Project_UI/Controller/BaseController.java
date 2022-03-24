package com.csi2132_group24.Project_UI.Controller;

import com.csi2132_group24.Project_UI.DTO.Patient;
import com.csi2132_group24.Project_UI.Security.CustomUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class BaseController {

    @GetMapping("/roles")
    public String getDefault(Model model){
        CustomUserDetails user = getLoggedInUser();
        return "roles";
    }

    public CustomUserDetails getLoggedInUser(){
        return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
