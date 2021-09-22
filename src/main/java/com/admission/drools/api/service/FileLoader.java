package com.admission.drools.api.service;

import org.kie.api.runtime.KieSession;

public interface FileLoader {
    public KieSession kieSession(String key, String fileName) throws RuntimeException;
}
