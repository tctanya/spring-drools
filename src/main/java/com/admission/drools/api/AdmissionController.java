package com.admission.drools.api;

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
    public Student orderNow(@RequestBody Student student) throws Exception {
        session.insert(student);
        session.fireAllRules();
        if (student.getStudentId() == null) {
            throw new Exception("Combination of school : "+ student.getSchoolName() + " and student's previous percentage : " + student
            .getPreviousPercentage() + " is not up to the mark for getting admission.");

        }
        return student;
    }

}
