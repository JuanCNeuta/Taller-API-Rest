/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.customers.presentation.rest;

import co.unicauca.customers.domain.service.CustomerService;
import co.unicauca.customers.domain.entity.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * API REST de los servicios web. Es muy simple por ahora, en otra versión se
 * hará una API más robusta. Son nuestros servicios web. La anotación @Path
 * indica la URL en la cual responderá los servicios. Esta anotación se puede
 *  * poner a nivel de clase y método. En este ejemplo todos los servicios
 * comparten el mismo Path, la acción se hacer mediante la anotació GET
 * (consultar), POST (agregar), PUT (editar), DELETE (eliminar).
 *
 * @author Juan Neuta
 */

@Stateless
@Path("customers")
public class CustomerController {
   
    /**
    * Se inyecta la única implementación que hay de ProductService
    */
    @Inject
    private CustomerService service;
    
    public CustomerController() {
        
    }
    
    
    /*
    Su uso desde consola mediante client url:
    curl -X GET http://localhost:8080/TravelAgency-API-REST/customer-service/customers/
    */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Customer findById(@PathParam("id") int id) {
        return service.findById(id);
    }
    
    /*
    Su uso desde consola mediante client url:
    curl -X POST \
        http://localhost:8080/TravelAgency-API-REST/customer-service/customers/ \
        -H 'Content-Type: application/json' \
        -d '{
            "address": "Calle 14 No 11-11 Popayan",
            "email": "jneuta@unicauca.edu.co",
            "firstName": "Juan",
            "gender": "Masculino",
            "id": 98000011,
            "lastName": "Neuta",
            "mobile": "3138269428"
            }'
    */
    
    @POST
     @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
     public String create(Customer cust) {
         if (service.create(cust)) {
             return "{\"ok\":\"true\", \"mensaje\":\"Cliente creado\",\"errores\":\"\"}";
         } else {
             return "{\"ok\":\"false\", \"mensaje\":\"No se pudo crear el Cliente\",\"errores\":\"Id ya existe\"}";
         }
     }
}


