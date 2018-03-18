package com.example.projectsapi.controllers;

import com.example.projectsapi.dataviews.DataViews;
import com.example.projectsapi.models.Project;
import com.example.projectsapi.repositories.ProjectRepository;
import com.example.projectsapi.repositories.RegionRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectsController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private RegionRepository regionRepository;

    @JsonView(DataViews.ProjectView.class)
    @GetMapping("/all")
    public Iterable<Project> findAllProjects() {
        return projectRepository.findAll();
    }


}
