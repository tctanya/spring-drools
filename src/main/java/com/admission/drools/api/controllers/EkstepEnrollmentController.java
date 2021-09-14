package com.admission.drools.api.controllers;

import com.admission.drools.api.model.EkstepLearner;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EkstepEnrollmentController {
    @Autowired
    private KieSession session;

    @PostMapping("/v1/enrollLearner/ekstep")
    public EkstepLearner enrollLearner(@RequestBody EkstepLearner ekstepLearner) throws Exception {
        session.insert(ekstepLearner);
        session.fireAllRules();
        if (ekstepLearner.getCourseEnrolled() == null) {
            throw new Exception("Bad Request Exception !!");
        }
        return ekstepLearner;
    }
}
