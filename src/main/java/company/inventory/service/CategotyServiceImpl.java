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
public class CategotyServiceImpl implements ICategoryService{
    /*METODO DE BUSQUEDA DE TODOS LAS CATEGORIAS */
    @Autowired //Decorador para inyectar
    private ICategoryDao categoryDao;
    
    @Override
    @Transactional(readOnly = true) 
    public ResponseEntity<CategoryResponseRest> search() {
        
      CategoryResponseRest response = new CategoryResponseRest();
      
      try {

        List<Category> category = (List<Category>) categoryDao.findAll();
        response.getCategoryResponse().setCategory(category);
        response.setMetadata("Respuesta OK","00", "Respuesta exitosa");

      }catch (Exception e){

        response.setMetadata("Respuesta nok","-1", "Error al consultar");
        e.getStackTrace();
        return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

      }
      return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
    }
    /*AGREGAR comentarios a todas  las lineas creadas hasta el momento */

    /*METODO DE BUSQUEDA POR ID */
    @Override
    @Transactional(readOnly = true) 
    public ResponseEntity<CategoryResponseRest> searchById(Long id) {
      
      CategoryResponseRest response = new CategoryResponseRest();
      List<Category> list = new ArrayList<>();
      try {

          Optional<Category> category = categoryDao.findById(id);

          if(category.isPresent()){
            list.add(category.get());
            response.getCategoryResponse().setCategory(list);
            response.setMetadata("Respuesta ok","00", "Categoria encontrada");
          }else{
            response.setMetadata("Respuesta nok","-1", "Categoria no encontrada");
            return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.NOT_FOUND);
          }

      }catch (Exception e){

        response.setMetadata("Respuesta nok","-1", "Error al consultar por id");
        e.getStackTrace();
        return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

      }
      return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
    }
     
     
    
}
