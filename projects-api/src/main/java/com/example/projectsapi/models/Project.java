package com.example.projectsapi.models;


import javax.persistence.*;

import com.example.projectsapi.dataviews.DataViews;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "PROJECTS")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_ID")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private Long projectId;

    @Column(name = "PROJECT_NAME")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private String projectName;

    @Column(name = "CLIENT")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private String client;

    @JsonView({DataViews.ProjectView.class})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION_ID")
    private Region region;

    @Column(name = "ADDRESS")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private String address;

    @Column(name = "ZIPCODE")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private Long zipcode;

    @Column(name = "CITY")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private String city;

    @Column(name = "MEGAWATTS")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private float megawatts;

    @Column(name = "BUDGET")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private float budget;

    @Column(name = "DATE_SURVEY")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private Date dateSurvey;

    @Column(name = "DATE_CONTRACT")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private Date dateContract;

    @Column(name = "DATE_START_CONSTRUCTION")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private Date dateStartConstruction;

    @Column(name = "DATE_INTERCONNECTION")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private Date dateInterconnection;

    @Column(name = "DATE_OPERABLE")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private Date dateOperable;

    @Column(name = "DATE_COMMISSION")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private Date dateCommission;

    @Column(name = "SURVEY_COMPLETE")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private boolean surveyComplete;

    @Column(name = "CONTRACT_SIGNED")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private boolean contractSigned;

    @Column(name = "CONSTRUCTION_STARTED")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private boolean constructionStarted;

    @Column(name = "INTERCONNECTED")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private boolean interconnected;

    @Column(name = "OPERABLE")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private boolean operable;

    @Column(name = "COMMISSIONED")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private boolean commissioned;

    @Column(name = "LINK_PLANS")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private String linkPlans;

    @Column(name = "LINK_CONTRACT")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private String linkContract;

    @Column(name = "LINK_ENV_IMPACT_REPORT")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private String linkEnvImpactReport;

    @Column(name = "NOTES")
    @JsonView({DataViews.ProjectView.class, DataViews.RegionView.class})
    private String notes;

    public Project(
            String projectName,
            String client,
            Region region,
            String address,
            Long zipcode,
            String city,
            float megawatts,
            float budget,
            Date dateSurvey,
            Date dateContract,
            Date dateStartConstruction,
            Date dateInterconnection,
            Date dateOperable,
            Date dateCommission,
            boolean surveyComplete,
            boolean contractSigned,
            boolean constructionStarted,
            boolean interconnected,
            boolean operable,
            boolean commissioned,
            String linkPlans,
            String linkContract,
            String linkEnvImpactReport,
            String notes
    ) {
        this.projectName = projectName;
        this.client = client;
        this.region = region;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.megawatts = megawatts;
        this.budget = budget;
        this.dateSurvey = dateSurvey;
        this.dateContract = dateContract;
        this.dateStartConstruction = dateStartConstruction;
        this.dateInterconnection = dateInterconnection;
        this. dateOperable = dateOperable;
        this.dateCommission = dateCommission;
        this.surveyComplete = surveyComplete;
        this.contractSigned = contractSigned;
        this.constructionStarted = constructionStarted;
        this.interconnected = interconnected;
        this.operable = operable;
        this.commissioned = commissioned;
        this. linkPlans = linkPlans;
        this.linkContract = linkContract;
        this.linkEnvImpactReport = linkEnvImpactReport;
        this.notes = notes;
    }
}
