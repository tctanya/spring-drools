package com.admission.drools.api.serviceImpl;

import com.admission.drools.api.model.GradeManager;
import com.admission.drools.api.service.FileLoader;
import com.admission.drools.api.service.GradeManagerService;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GradeManagerServiceImpl implements GradeManagerService {
    @Autowired
    private KieSession session;
    @Autowired
    FileLoader fileLoader;
    @Value("${niit.grade.calculator.xlsx.read}")
    String fileName;

    public GradeManager gradeInterpretation(GradeManager gradeManager) {
        System.out.println("Config File Name..." + fileName);
        session = fileLoader.kieSession("1", fileName);
        session.insert(gradeManager);
        session.fireAllRules();
        session.dispose();
        if (gradeManager.getInterpretation() == null) {
            gradeManager.setInterpretation("Not eligible for grading.");
            gradeManager.setGrade("Not Graded.");
        }
        return gradeManager;
    }
}
