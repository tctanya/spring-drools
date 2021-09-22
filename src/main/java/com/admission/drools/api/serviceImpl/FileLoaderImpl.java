package com.admission.drools.api.serviceImpl;

import com.admission.drools.api.service.FileLoader;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.stereotype.Service;

@Service
public class FileLoaderImpl implements FileLoader {
    private KieServices kieServices = KieServices.Factory.get();

    public KieSession kieSession(String key, String fileName) throws RuntimeException {
        KieFileSystem kieFileSystem = getKieFileSystem(fileName);
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        KieModule kieModule = kieBuilder.getKieModule();
        KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
        KieSession kieSession = kieContainer.newKieSession();
        return kieSession;
    }

    private KieFileSystem getKieFileSystem(String fileName) {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource(fileName));
        return kieFileSystem;
    }

}
