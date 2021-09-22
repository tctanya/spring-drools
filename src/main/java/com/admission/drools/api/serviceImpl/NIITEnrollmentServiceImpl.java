package com.admission.drools.api.serviceImpl;

import com.admission.drools.api.model.NIITLearner;
import com.admission.drools.api.service.FileLoader;
import com.admission.drools.api.service.NIITEnrollmentService;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NIITEnrollmentServiceImpl implements NIITEnrollmentService {
    @Autowired
    private KieSession session;
    @Autowired
    FileLoader fileLoader;
    @Value("${niit.learner.xlsx.read}")
    String fileName;

    public NIITLearner checkEligibility(NIITLearner niitLearner) throws RuntimeException {
        System.out.println("Config File Name..." + fileName);
        session = fileLoader.kieSession("1", fileName);
        session.insert(niitLearner);
        session.fireAllRules();
        session.dispose();
        if (niitLearner.getEligibility() == null) {
            niitLearner.setEligibility("Not Eligible");
        }
        return niitLearner;
    }

}
