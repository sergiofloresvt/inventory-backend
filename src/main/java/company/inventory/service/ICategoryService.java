package company.inventory.service;

import org.springframework.http.ResponseEntity;

import company.inventory.response.CategoryResponseRest;

public interface ICategoryService {
    
    public ResponseEntity <CategoryResponseRest> search();

    
}
