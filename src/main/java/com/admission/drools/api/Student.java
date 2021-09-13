package com.admission.drools.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String studentName;
    private String schoolName;
    private String studentId;
    private int previousPercentage;
}
