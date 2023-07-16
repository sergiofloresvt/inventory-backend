package company.inventory.response;

import java.util.List;
import company.inventory.model.Category;
import lombok.Data;

@Data
public class CategoryResponse {
    
    private List<Category> category;
}
