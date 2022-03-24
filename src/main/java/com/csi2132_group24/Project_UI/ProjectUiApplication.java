package com.csi2132_group24.Project_UI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProjectUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectUiApplication.class, args);
	}

}
