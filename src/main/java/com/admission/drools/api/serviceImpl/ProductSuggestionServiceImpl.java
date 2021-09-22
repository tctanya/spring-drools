package com.admission.drools.api.serviceImpl;

import com.admission.drools.api.model.ProductSuggestion;
import com.admission.drools.api.service.FileLoader;
import com.admission.drools.api.service.ProductSuggestionService;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProductSuggestionServiceImpl implements ProductSuggestionService {
    @Autowired
    private KieSession session;
    @Autowired
    FileLoader fileLoader;
    @Value("${product.suggestion.xlsx.read}")
    String fileName;

    public ProductSuggestion getSuggestedCourses(ProductSuggestion productSuggestion) throws RuntimeException {
        System.out.println("Config File Name..." + fileName);
        session = fileLoader.kieSession("1", fileName);
        session.insert(productSuggestion);
        session.fireAllRules();
        session.dispose();
        return productSuggestion;
    }
}
