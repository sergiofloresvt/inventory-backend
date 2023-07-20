package company.inventory.service;

import org.springframework.http.ResponseEntity;

import company.inventory.model.Category;
import company.inventory.response.CategoryResponseRest;

public interface ICategoryService {
    
    public ResponseEntity <CategoryResponseRest> search();
    public ResponseEntity <CategoryResponseRest> searchById(Long id);
    public ResponseEntity <CategoryResponseRest> save(Category category);
    public ResponseEntity <CategoryResponseRest> update(Category category, Long id);
    
}
