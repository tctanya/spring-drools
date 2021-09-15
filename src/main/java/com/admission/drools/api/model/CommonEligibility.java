package com.admission.drools.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonEligibility {
    private String organisation;
    private String learnerName;
    private int hscPercentage;
    private int sscPercentage;
    private String subject;
    private String eligibility;
}
