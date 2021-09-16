package com.admission.drools.api.controllers;

import com.admission.drools.api.model.CGILearner;
import com.admission.drools.api.model.EkstepLearner;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CGIEnrollmentController {
    @Autowired
    private KieSession session;

    @PostMapping("/v1/enrollLearner/cgi")
    public CGILearner enrollLearner(@RequestBody CGILearner cgiLearner) throws Exception {
        session.insert(cgiLearner);
        session.fireAllRules();
        if (cgiLearner.getEligibility() == null) {
            cgiLearner.setEligibility("Not Eligible for any courses.");
        }
        return cgiLearner;
    }
}
