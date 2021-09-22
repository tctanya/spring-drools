package com.admission.drools.api.service;

import com.admission.drools.api.model.CommonEligibility;

public interface CommonEligibilityService {
    public CommonEligibility checkCommonEligibility(CommonEligibility commonEligibility) throws RuntimeException;
}
