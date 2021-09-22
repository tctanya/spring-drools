package com.admission.drools.api.controllers;

import com.admission.drools.api.model.CommonEligibility;
import com.admission.drools.api.service.CommonEligibilityService;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/v1/common")
public class CommonEligibilityController {
    @Autowired
    CommonEligibilityService eligibilityService;

    @PostMapping("/eligibility/check")
    public CommonEligibility checkEligibility(@RequestBody CommonEligibility commonEligibility) throws Exception {
        commonEligibility.setSubject(commonEligibility.getSubject().toLowerCase(Locale.ROOT));
        eligibilityService.checkCommonEligibility(commonEligibility);
        return commonEligibility;
    }
}
