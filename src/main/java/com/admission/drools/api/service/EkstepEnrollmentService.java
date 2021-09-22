package com.admission.drools.api.service;

import com.admission.drools.api.model.EkstepLearner;

public interface EkstepEnrollmentService {
    public EkstepLearner getCourseEnrolled(EkstepLearner ekstepLearner) throws RuntimeException;
}
