package company.inventory.dao;

import org.springframework.data.repository.CrudRepository;

import company.inventory.model.Category;

public interface ICategoryDao extends CrudRepository <Category, Long> {
    /*Esta interfas Crud tiene todo los metodos (Create, Read, Update, Delete)
    para acceder los datos de la clase Category 
      */
} 
