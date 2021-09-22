package com.admission.drools.api.controllers;

import com.admission.drools.api.model.MultipleCommonCondition;
import com.admission.drools.api.service.MultipleCommonConditionService;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/v1/common/multiple")
public class MultipleCommonConditionController {
    @Autowired
    MultipleCommonConditionService multipleCommonConditionService;
    @PostMapping("/eligibility/check")
    public MultipleCommonCondition checkEligibility(@RequestBody MultipleCommonCondition multipleCommonCondition) throws Exception {
        multipleCommonCondition.setUniversity(multipleCommonCondition.getUniversity().toLowerCase(Locale.ROOT));
        multipleCommonCondition.setProduct(multipleCommonCondition.getProduct().toLowerCase(Locale.ROOT));
        multipleCommonConditionService.checkEligibility(multipleCommonCondition);
        return multipleCommonCondition;
    }
}
