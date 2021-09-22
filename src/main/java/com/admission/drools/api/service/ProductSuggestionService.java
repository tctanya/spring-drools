package com.admission.drools.api.service;

import com.admission.drools.api.model.ProductSuggestion;

public interface ProductSuggestionService {
    public ProductSuggestion getSuggestedCourses(ProductSuggestion productSuggestion) throws RuntimeException;
}
