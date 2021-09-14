package com.admission.drools.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CGILearner {
    private String courseName;
    private String learnerName;
    private String learnerRegistrationNumber;
    private int hscPercentage;
    private int sscPercentage;
    private int graduationPercentage;
    private int cgiEntranceExamPercentage;
    private String eligibility;
}
