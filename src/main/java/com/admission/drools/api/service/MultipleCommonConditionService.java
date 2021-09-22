package com.admission.drools.api.service;

import com.admission.drools.api.model.MultipleCommonCondition;
import org.springframework.web.bind.annotation.RequestBody;

public interface MultipleCommonConditionService {
    public MultipleCommonCondition checkEligibility(MultipleCommonCondition multipleCommonCondition) throws RuntimeException;
}
