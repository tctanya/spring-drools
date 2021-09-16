package com.admission.drools.api.controllers;

import com.admission.drools.api.model.GradeManager;
import com.admission.drools.api.model.NIITLearner;
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

    @PostMapping("/v1/enrollLearner/niit")
    public NIITLearner enrollLearner(@RequestBody NIITLearner niitLearner) throws Exception {
        session.insert(niitLearner);
        session.fireAllRules();
        if (niitLearner.getEligibility() == null) {
            niitLearner.setEligibility("Not Eligible");
        }
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
        if(gradeManager.getMarksObtained()>0 && gradeManager.getMarksObtained()<=100){
            gradeManager.setMarksObtained(gradeManager.getMarksObtained());
        }
        session.insert(gradeManager);
        session.fireAllRules();
        if (gradeManager.getInterpretation() == null) {
            gradeManager.setInterpretation("Not eligible for grading.");
            gradeManager.setGrade("Not Graded.");
        }
        return gradeManager;
    }
}
