package company.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
