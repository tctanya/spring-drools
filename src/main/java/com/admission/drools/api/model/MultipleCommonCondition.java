package com.admission.drools.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultipleCommonCondition {
    private String learnerName;
    private String university;
    private String product;
    private String background;
    private String eligibility;
    private int scholarshipTestPercentage;
    private String scholarship;
//    private String concessionInFee;
}
