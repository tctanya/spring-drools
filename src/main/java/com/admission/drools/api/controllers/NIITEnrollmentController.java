package com.admission.drools.api.controllers;

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
    public NIITLearner enrollLearner(@RequestBody NIITLearner NIITLearner) throws Exception {
        session.insert(NIITLearner);
        session.fireAllRules();
        if (NIITLearner.getEligibility() == null) {
            throw new Exception("Bad Request Exception !!");
        }
        return NIITLearner;
    }

    @PostMapping("/v1/courseGrade/niit")
    public Map<String, Object> gradeCalculation(@RequestBody Map<String, Object> reqMap) throws Exception {
        System.out.println(reqMap.get("marks"));
//        int marks= Integer.parseInt(reqMap.get("marks").toString());
//        if ((Integer.parseInt(reqMap.get("marks").toString()) > 90 && Integer.parseInt(reqMap.get("marks").toString()) <= 100))
//        {
//            reqMap.put("interpretation", "Outstanding");
//        }
        session.insert(reqMap);
        session.fireAllRules();
//        if (reqMap.getMarks() == null) {
//            throw new Exception("Bad Request Exception !!");
//        }
        return reqMap;
    }
}
