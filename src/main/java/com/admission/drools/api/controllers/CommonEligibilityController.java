package com.admission.drools.api.controllers;

import com.admission.drools.api.model.CommonEligibility;
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
    private KieSession session;

    @PostMapping("/eligibility/check")
    public CommonEligibility checkEligibility(@RequestBody CommonEligibility commonEligibility) throws Exception {
        commonEligibility.setSubject(commonEligibility.getSubject().toLowerCase(Locale.ROOT));
        session.insert(commonEligibility);
        session.fireAllRules();
        if (commonEligibility.getEligibility() == null) {
            throw new Exception("Bad Request Exception. Learner is not eligible to be enrolled in any product.");
        }
        return commonEligibility;
    }
}
