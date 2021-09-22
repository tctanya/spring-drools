package com.admission.drools.api.serviceImpl;

import com.admission.drools.api.model.EkstepLearner;
import com.admission.drools.api.service.EkstepEnrollmentService;
import com.admission.drools.api.service.FileLoader;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EkstepEnrollmentServiceImpl implements EkstepEnrollmentService {
    @Autowired
    private KieSession session;
    @Autowired
    FileLoader fileLoader;
    @Value("${ekstep.learner.xlsx.read}")
    String fileName;

    public EkstepLearner getCourseEnrolled(EkstepLearner ekstepLearner) throws RuntimeException {
        System.out.println("Config File Name..." + fileName);
        session = fileLoader.kieSession("1", fileName);
        session.insert(ekstepLearner);
        session.fireAllRules();
        session.dispose();
        if (ekstepLearner.getCourseEnrolled() == null) {
            ekstepLearner.setCourseEnrolled("Not Eligible for Engineering Courses.");
        }
        return ekstepLearner;
    }
}
