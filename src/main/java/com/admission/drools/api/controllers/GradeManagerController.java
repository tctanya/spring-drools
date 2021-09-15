package com.admission.drools.api.controllers;

import com.admission.drools.api.model.GradeManager;
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
    private KieSession session;

    @PostMapping("/niit/calculate")
    public GradeManager calculateGrade(@RequestBody GradeManager gradeManager) throws Exception {
        session.insert(gradeManager);
        session.fireAllRules();
        if (gradeManager.getInterpretation() == null) {
            throw new Exception("Bad Request Exception. Either learner is failed or not graded.");
        }
        return gradeManager;
    }
}
