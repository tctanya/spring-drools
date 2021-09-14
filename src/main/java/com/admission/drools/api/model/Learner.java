package com.admission.drools.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Learner {
    private String learnerName;
    private String organisation;
    private int hscPercentage;
    private int sscPercentage;
    private int graduationPercentage;
//    private String niitEntracePercentage;
    private boolean EntryExamCleared;
    private String courseEnrolled;
}
