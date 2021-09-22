package com.admission.drools.api.service;

import com.admission.drools.api.model.CGILearner;

public interface CGIEnrollmentService {
    public CGILearner checkEligibility(CGILearner cgiLearner) throws RuntimeException;
}
