package com.admission.drools.api.serviceImpl;

import com.admission.drools.api.model.CommonEligibility;
import com.admission.drools.api.service.CommonEligibilityService;
import com.admission.drools.api.service.FileLoader;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CommonEligibilityServiceImpl implements CommonEligibilityService {
    @Autowired
    private KieSession session;
    @Autowired
    FileLoader fileLoader;
    @Value("${common.eligibility.check.xlsx.read}")
    String fileName;

    public CommonEligibility checkCommonEligibility(CommonEligibility commonEligibility) throws RuntimeException{
        System.out.println("Config File Name..."+fileName);
        session = fileLoader.kieSession("1", fileName);
        session.insert(commonEligibility);
        session.fireAllRules();
        session.dispose();
        if (commonEligibility.getEligibility() == null) {
            commonEligibility.setEligibility("Not Eligible for any product.");
        }
        return commonEligibility;
    }
}
