package com.admission.drools.api.controllers;

import com.admission.drools.api.model.GradeManager;
import com.admission.drools.api.model.NIITLearner;
import com.admission.drools.api.service.GradeManagerService;
import com.admission.drools.api.service.NIITEnrollmentService;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class NIITEnrollmentController {
    @Autowired
    private KieSession session;
    @Autowired
    NIITEnrollmentService enrollmentService;
    @Autowired
    GradeManagerService managerService;

    @PostMapping("/v1/enrollLearner/niit")
    public NIITLearner enrollLearner(@RequestBody NIITLearner niitLearner) throws Exception {
        enrollmentService.checkEligibility(niitLearner);
        return niitLearner;
    }

    @PostMapping("/v1/courseGrade/niit")
    public Map<String, Object> gradeCalculation(@RequestBody Map<String, Object> reqMap) throws Exception {
        System.out.println(reqMap.get("marks"));
        session.insert(reqMap);
        session.fireAllRules();
        return reqMap;
    }

    @PostMapping("/v2/courseGrade/niit")
    public GradeManager calculateGrade(@RequestBody GradeManager gradeManager) throws Exception {
        if (gradeManager.getMarksObtained() > 0 && gradeManager.getMarksObtained() <= 100) {
            gradeManager.setMarksObtained(gradeManager.getMarksObtained());
        }
        managerService.gradeInterpretation(gradeManager);
        return gradeManager;
    }
}
