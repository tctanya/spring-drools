package com.admission.drools.api.controllers;

import com.admission.drools.api.model.GradeManager;
import com.admission.drools.api.service.FileLoader;
import com.admission.drools.api.service.GradeManagerService;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/grade")
public class GradeManagerController {
    @Autowired
    GradeManagerService managerService;
    @PostMapping("/niit/calculate")
    public GradeManager calculateGrade(@RequestBody GradeManager gradeManager) throws Exception {
        if (gradeManager.getMarksObtained() > 0 && gradeManager.getMarksObtained() <= 100) {
            gradeManager.setMarksObtained(gradeManager.getMarksObtained());
        }
        managerService.gradeInterpretation(gradeManager);
        return gradeManager;
    }
}
