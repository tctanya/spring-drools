package com.admission.drools.api.controllers;

import com.admission.drools.api.model.Learner;
import com.admission.drools.api.model.Student;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdmissionController {
    @Autowired
    private KieSession session;

    @PostMapping("/v1/admission")
    public Student createAdmission(@RequestBody Student student) throws Exception {
        session.insert(student);
        session.fireAllRules();
        if (student.getStudentId() == null) {
            throw new Exception("Combination of school : "+ student.getSchoolName() + " and student's previous percentage : " + student
            .getPreviousPercentage() + " is not up to the mark for getting admission.");

        }
        return student;
    }

    @PostMapping("/v2/admission")
    public Learner enrollLearner(@RequestBody Learner learner) throws Exception {
        session.insert(learner);
        session.fireAllRules();
        if (learner.getCourseEnrolled() == null) {
//            throw new Exception("Combination of school : "+ student.getSchoolName() + " and student's previous percentage : " + student
//                    .getPreviousPercentage() + " is not up to the mark for getting admission.");
            throw new Exception("Bad Request Exception !!");

        }
        return learner;
    }
}
