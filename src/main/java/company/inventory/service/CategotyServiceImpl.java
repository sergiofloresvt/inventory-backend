package company.inventory.service;
import java.util.List;


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
        return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);

      }
      return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
    }
    /*AGREGAR comentarios a todas  las lineas creadas hasta el momento */
    
}
