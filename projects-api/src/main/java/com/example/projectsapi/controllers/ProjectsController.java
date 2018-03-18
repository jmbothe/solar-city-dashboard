package com.example.projectsapi.controllers;

import com.example.projectsapi.dataviews.DataViews;
import com.example.projectsapi.models.Project;
import com.example.projectsapi.repositories.ProjectRepository;
import com.example.projectsapi.repositories.RegionRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    // TODO: is array the right data structure for function parameter??
    // ANSWER: yes, because size is declared in advance, so insertion is fast

    @JsonView(DataViews.ProjectView.class)
    @GetMapping("/id/{ids}")
    public Iterable<Optional> findProjectsById(@PathVariable Long[] ids) {
        List<Optional> responseBody = new ArrayList<>();

        for (Long id : ids) {
            responseBody.add(projectRepository.findById(id));
        }
        return responseBody;
    }

    @JsonView(DataViews.RegionView.class)
    @GetMapping("/region/{region}")
    public Optional findProjectsByRegion(@PathVariable Long region) {
        return regionRepository.findById(region);
    }

}
