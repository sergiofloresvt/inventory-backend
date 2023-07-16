package company.inventory.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponseRest extends ResponseRest {
    /*Extendemos para heredar la clase ResponseRest y sus atributos
     */

     private CategoryResponse categoryResponse = new CategoryResponse();{

     }
}
