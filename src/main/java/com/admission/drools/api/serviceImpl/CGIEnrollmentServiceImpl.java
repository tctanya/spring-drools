package com.admission.drools.api.serviceImpl;

import com.admission.drools.api.model.CGILearner;
import com.admission.drools.api.service.CGIEnrollmentService;
import com.admission.drools.api.service.FileLoader;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CGIEnrollmentServiceImpl implements CGIEnrollmentService {
    @Autowired
    private KieSession session;
    @Autowired
    FileLoader fileLoader;
    @Value("${cgi.learner.xlsx.read}")
    String fileName;

    public CGILearner checkEligibility(CGILearner cgiLearner) throws RuntimeException {
        System.out.println("Config File Name..." + fileName);
        session = fileLoader.kieSession("1", fileName);
        session.insert(cgiLearner);
        session.fireAllRules();
        session.dispose();
        if (cgiLearner.getEligibility() == null) {
            cgiLearner.setEligibility("Not Eligible for any courses.");
        }
        return cgiLearner;
    }
}
