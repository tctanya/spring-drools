package com.admission.drools.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeManager {
    private String learnerId;
    private String courseEnrolled;
    private double marksObtained;
    private String interpretation;
    private String grade;
}
