package co.unicauca.customers.domain.service;

import co.unicauca.customers.access.ICustomerRepository;
import co.unicauca.customers.domain.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

/**
 * Servicio de clientes. Da acceso a la lógica de negocio
 *
 * @author Juan Neuta
 */

@RequestScoped
public class CustomerService {

       /**
    * Inyecta una implementación del repositorio
    */
    @Inject
    @Default
    ICustomerRepository repo;

    /**
     * Constructor parametrizado. Hace inyeccion de dependencias
     *
     * @param repo repositorio de tipo ICustomerRepository
     */
    public CustomerService() {
    }

    public Customer findById(int id) {
        return repo.findById(id);
    }
    
    public boolean create(Customer cust) {
        return repo.create(cust);
    }

}
