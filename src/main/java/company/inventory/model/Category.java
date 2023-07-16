package company.inventory.model;

import java.io.Serializable;

// import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/*Definimos esta clase como una identidad con 
 * el decorador @Entity
 */
@Data
@Entity
@Table(name="category")
/* Le pasamos el nombre que va tener nuestra
 * tabala en la base de datos
 */

/*Esta clase la hacemos serializable para que el id sea
incremental */ 
public class Category implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*Con este decorador indicamos que el id va ser
     * autoincremental.
     */
    private Long id;
    private String nombre;
    private String description;
    

}
