package com.admission.drools.api.serviceImpl;

import com.admission.drools.api.model.MultipleCommonCondition;
import com.admission.drools.api.service.FileLoader;
import com.admission.drools.api.service.MultipleCommonConditionService;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MultipleCommonConditionServiceImpl implements MultipleCommonConditionService {
    @Autowired
    private KieSession session;
    @Autowired
    FileLoader fileLoader;
    @Value("${multiple.common.eligibility.check.xlsx.read}")
    String fileName;

    public MultipleCommonCondition checkEligibility(MultipleCommonCondition multipleCommonCondition) throws RuntimeException {
        System.out.println("Config File Name..." + fileName);
        session = fileLoader.kieSession("1", fileName);
        session.insert(multipleCommonCondition);
        session.fireAllRules();
        session.dispose();
        if (multipleCommonCondition.getScholarship() == null) {
            multipleCommonCondition.setEligibility("Learner is not eligible for any scholarship.");
            multipleCommonCondition.setScholarship("Sorry, you are not qualified for scholarship.");
        }
        return multipleCommonCondition;
    }
}
