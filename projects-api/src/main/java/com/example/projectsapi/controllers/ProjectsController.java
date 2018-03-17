package com.example.projectsapi.controllers;

import com.example.projectsapi.models.Project;
import com.example.projectsapi.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectsController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/")
    public Iterable<Project> findAllProjects() {
        return projectRepository.findAll();
    }
}
