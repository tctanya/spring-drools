package com.admission.drools.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EkstepLearner {
    private String learnerName;
    private String organisation;
    private int graduationPercentage;
    private int entranceExamPercentage;
    private boolean interviewCleared;
    private String courseEnrolled;
}
