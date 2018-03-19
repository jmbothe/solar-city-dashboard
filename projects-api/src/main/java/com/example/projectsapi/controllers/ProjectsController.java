package com.example.projectsapi.controllers;

import com.example.projectsapi.dataviews.DataViews;
import com.example.projectsapi.models.Project;
import com.example.projectsapi.repositories.ProjectRepository;
import com.example.projectsapi.repositories.RegionRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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

    @JsonView(DataViews.ProjectView.class)
    @GetMapping("/id/{ids}")
    public Optional[] findProjectsById(@PathVariable Long[] ids) {
        Optional[] responseBody = new Optional[ids.length];

        int i = 0;
        for (Long id : ids) {
            responseBody[i] = projectRepository.findById(id);
            i++;
        }
        return responseBody;
    }

    @JsonView(DataViews.RegionView.class)
    @GetMapping("/region/{region}")
    public Optional findProjectsByRegion(@PathVariable Long region) {
        return regionRepository.findById(region);
    }

    @PatchMapping("/update-dates/{id}")
    public HttpStatus updateDates(@PathVariable long id, @RequestBody Project projectRequest) {
        Project project = projectRepository.findById(id).get();

        project.setDateSurvey(projectRequest.getDateSurvey());
        project.setDateContract(projectRequest.getDateContract());
        project.setDateStartConstruction(projectRequest.getDateStartConstruction());
        project.setDateInterconnection(projectRequest.getDateInterconnection());
        project.setDateOperable(projectRequest.getDateOperable());
        project.setDateCommission(projectRequest.getDateCommission());

        projectRepository.save(project);
        return HttpStatus.OK;
    }

    @PatchMapping("/toggle-milestones/{id}")
    public HttpStatus toggleMilestones(@PathVariable long id, @RequestBody Project projectRequest) {
        Project project = projectRepository.findById(id).get();

        project.setSurveyComplete(projectRequest.isSurveyComplete());
        project.setContractSigned(projectRequest.isContractSigned());
        project.setConstructionStarted(projectRequest.isConstructionStarted());
        project.setInterconnected(projectRequest.isInterconnected());
        project.setOperable(projectRequest.isOperable());
        project.setCommissioned(projectRequest.isCommissioned());

        projectRepository.save(project);
        return HttpStatus.OK;
    }

    @PatchMapping("/edit-notes/{id}")
    public HttpStatus editNotes(@PathVariable long id, @RequestBody Project projectRequest) {
        Project project = projectRepository.findById(id).get();

        project.setNotes(projectRequest.getNotes());

        projectRepository.save(project);
        return HttpStatus.OK;
    }

}
