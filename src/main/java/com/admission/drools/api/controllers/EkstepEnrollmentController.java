package com.admission.drools.api.controllers;

import com.admission.drools.api.model.EkstepLearner;
import com.admission.drools.api.service.EkstepEnrollmentService;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EkstepEnrollmentController {
    @Autowired
    EkstepEnrollmentService enrollmentService;

    @PostMapping("/v1/enrollLearner/ekstep")
    public EkstepLearner enrollLearner(@RequestBody EkstepLearner ekstepLearner) throws Exception {
        enrollmentService.getCourseEnrolled(ekstepLearner);
        return ekstepLearner;
    }
}
