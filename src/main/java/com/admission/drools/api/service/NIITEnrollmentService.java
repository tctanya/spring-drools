package com.admission.drools.api.service;

import com.admission.drools.api.model.NIITLearner;

public interface NIITEnrollmentService {
    public NIITLearner checkEligibility(NIITLearner niitLearner) throws RuntimeException;
}
