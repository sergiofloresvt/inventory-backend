package company.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import company.inventory.model.Category;
import company.inventory.response.CategoryResponseRest;
import company.inventory.service.ICategoryService;

@RestController
/*
 * Este decorador es utilizado para indicar que esta clase es un
 * controlador de API REST y se encargará de manejar las solicitudes
 * HTTP entrantes y generar las respuestas
 * correspondientes.
 */
@RequestMapping("api/v1")
/*
 * La anotación @RequestMapping("api/v1") se utiliza para especificar el prefijo
 * de la URL para todas las rutas dentro de esta clase. En este caso, todas las
 * rutas dentro de CategoryRestController tendrán el prefijo "api/v1". Por lo
 * tanto, cualquier ruta definida dentro de este controlador comenzará con
 * "/api/v1".
 */
public class CategoryRestController {

    @Autowired
    private ICategoryService service;
    /**
     * get all categories
     * @return
     */
    @GetMapping("/categories")
    public ResponseEntity<CategoryResponseRest> serchCategories() {
        /*
         * Este método debe manejar solicitudes HTTP GET al endpoint "/categories".
         * Devolviendo un objeto ResponseEntity que envuelve un objeto
         * CategoryResponseRest.
         */

        ResponseEntity<CategoryResponseRest> response = service.search();
        return response;
        /*
         * En esta línea, se llama al método search() del servicio. El resultado se
         * asigna a la variable response, que también es un objeto
         * ResponseEntity<CategoryResponseRest>.
         */
    }
    /**
     * get categories by id
     * @param id
     * @return
     */
    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> serchCategoriesById(@PathVariable Long id){

        ResponseEntity<CategoryResponseRest> response = service.searchById(id);
        return response;
    }

    /**
     * save categories
     * @param Category
     * @return
     */
    @PostMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> save(@RequestBody Category category){

      ResponseEntity<CategoryResponseRest> response = service.save(category);
      return response;
    }
    /**
     * update categories
     * @param category
     * @param id
     * @return
     */
    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> update(
        @RequestBody Category category, @PathVariable Long id){

      ResponseEntity<CategoryResponseRest> response = service.update(category, id);
      return response;
    }
    /**
     * delete categorie for id
     * @param id
     * @return
     */
    @DeleteMapping("/categories/{id}")
        public ResponseEntity<CategoryResponseRest> deleteById( 
            @PathVariable Long id){

      ResponseEntity<CategoryResponseRest> response = service.deleteById(id);
      return response;
    }
    
}
