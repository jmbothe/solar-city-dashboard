package com.example.projectsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProjectsApi {

	public static void main(String[] args) {
		SpringApplication.run(ProjectsApi.class, args);
	}
}
