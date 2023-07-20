package company.inventory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import company.inventory.dao.ICategoryDao;
import company.inventory.model.Category;
import company.inventory.response.CategoryResponseRest;

@Service
public class CategotyServiceImpl implements ICategoryService {
  /* METODO DE BUSQUEDA DE TODOS LAS CATEGORIAS */
  @Autowired // Decorador para inyectar
  private ICategoryDao categoryDao;

  @Override
  @Transactional(readOnly = true)
  public ResponseEntity<CategoryResponseRest> search() {

    CategoryResponseRest response = new CategoryResponseRest();

    try {

      List<Category> category = (List<Category>) categoryDao.findAll();
      response.getCategoryResponse().setCategory(category);
      response.setMetadata("Respuesta OK", "00", "Respuesta exitosa");

    } catch (Exception e) {

      response.setMetadata("Respuesta nok", "-1", "Error al consultar");
      e.getStackTrace();
      return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
  }
  /* AGREGAR comentarios a todas las lineas creadas hasta el momento */

  /* METODO DE BUSQUEDA POR ID */
  @Override
  @Transactional(readOnly = true)
  public ResponseEntity<CategoryResponseRest> searchById(Long id) {

    CategoryResponseRest response = new CategoryResponseRest();
    List<Category> list = new ArrayList<>();
    try {

      Optional<Category> category = categoryDao.findById(id);

      if (category.isPresent()) {
        list.add(category.get());
        response.getCategoryResponse().setCategory(list);
        response.setMetadata("Respuesta ok", "00", "Categoria encontrada");
      } else {
        response.setMetadata("Respuesta nok", "-1", "Categoria no encontrada");
        return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.NOT_FOUND);
      }

    } catch (Exception e) {

      response.setMetadata("Respuesta nok", "-1", "Error al consultar por id");
      e.getStackTrace();
      return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
  }

  /* METODO PARA GURDAR UNA CATEGORIA */
  @Override
  @Transactional
  public ResponseEntity<CategoryResponseRest> save(Category category) {

    CategoryResponseRest response = new CategoryResponseRest();
    /**
     * Creamos una nueva instancia de CategoryResponseRest, que es una clase
     * personalizada para la llamada de la API.
     */
    List<Category> list = new ArrayList<>();
    /*
     * Creamos una lista vacia de tipo Category llamada list para
     * almacenar la categoria guardada (si tiene exito).
     */

    try {

      Category categorySaved = categoryDao.save(category);

      if (categorySaved != null) {
        list.add(0, categorySaved);
        response.getCategoryResponse().setCategory(list);
        response.setMetadata("Respuesta ok", "00", "Categoria guardada");
        /*
         * Si la categoría se guarda exitosamente (categorySaved != null), agrega la
         * categoría guardada a la lista 'list' y establece esta lista como parte del
         * objeto 'response'.
         */
      } else {
        response.setMetadata("Respuesta nok", "-1", "Categoria no guardada");
        return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.BAD_REQUEST);
        /*
         * Si la categoria no se guarda nos devuelve un mensaje con un codigo http
         * bad_request que indica que no fue exitoso el guardado.
         */
      }
      /*
       * Dentro del bloque try, el método intenta guardar el objeto Category
       * utilizando el método categoryDao.save(category), que es el responsable
       * de las operaciones de la base de datos
       */

    } catch (Exception e) {

      response.setMetadata("Respuesta nok", "-1", "Error al guardar categoria");
      e.getStackTrace();
      return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      /*
       * En caso de cualquier excepción durante el proceso, se ejecuta el bloque
       * catch, y establece un mensaje de error en los metadatos de la respuesta.
       * También registra la traza de pila de la excepción (pero no la maneja más
       * allá), y devuelve un ResponseEntity con el código de estado HTTP
       * HttpStatus.INTERNAL_SERVER_ERROR para indicar un error del servidor.
       */
    }
    return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
    /*
     * Finalmente, si todo salió bien, el método devuelve un ResponseEntity con el
     * código de estado HTTP HttpStatus.OK, lo que representa una respuesta exitosa
     * con los datos almacenados en el objeto response.
     */
  }

}
