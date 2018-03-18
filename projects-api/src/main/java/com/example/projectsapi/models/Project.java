package com.example.projectsapi.models;


import javax.persistence.*;
import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "PROJECTS")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @Column(name = "CLIENT")
    private String client;

    @Column(name = "REGION")
    private Long region;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "ZIPCODE")
    private Long zipcode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "MEGAWATTS")
    private float megawatts;

    @Column(name = "BUDGET")
    private float budget;

    @Column(name = "DATE_SURVEY")
    private Date dateSurvey;

    @Column(name = "DATE_CONTRACT")
    private Date dateContract;

    @Column(name = "DATE_START_CONSTRUCTION")
    private Date dateStartConstruction;

    @Column(name = "DATE_INTERCONNECTION")
    private Date dateInterconnection;

    @Column(name = "DATE_OPERABLE")
    private Date dateOperable;

    @Column(name = "DATE_COMMISSION")
    private Date dateCommission;

    @Column(name = "SURVEY_COMPLETE")
    private boolean surveyComplete;

    @Column(name = "CONTRACT_SIGNED")
    private boolean contractSigned;

    @Column(name = "CONSTRUCTION_STARTED")
    private boolean constructionStarted;

    @Column(name = "INTERCONNECTED")
    private boolean interconnected;

    @Column(name = "OPERABLE")
    private boolean operable;

    @Column(name = "COMMISSIONED")
    private boolean commissioned;

    @Column(name = "LINK_PLANS")
    private String linkPlans;

    @Column(name = "LINK_CONTRACT")
    private String linkContract;

    @Column(name = "LINK_ENV_IMPACT_REPORT")
    private String linkEnvImpactReport;

    public Project(
            String projectName,
            String client,
            Long region,
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
            String linkEnvImpactReport
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
    }
}