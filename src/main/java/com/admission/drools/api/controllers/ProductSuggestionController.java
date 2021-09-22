package com.admission.drools.api.controllers;

import com.admission.drools.api.model.ProductSuggestion;
import com.admission.drools.api.service.ProductSuggestionService;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductSuggestionController {
    @Autowired
    ProductSuggestionService productSuggestionService;
    @PostMapping("/v1/suggest/course")
    public ProductSuggestion suggestCourse(@RequestBody ProductSuggestion productSuggestion) throws Exception {
        if (productSuggestion.getPercentage() > 0 && productSuggestion.getPercentage() <= 100) {
            productSuggestion.setPercentage(productSuggestion.getPercentage());
        }
        productSuggestionService.getSuggestedCourses(productSuggestion);
        return productSuggestion;
    }
}
