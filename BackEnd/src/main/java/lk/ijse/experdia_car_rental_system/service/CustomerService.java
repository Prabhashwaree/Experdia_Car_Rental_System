package lk.ijse.experdia_car_rental_system.service;

import lk.ijse.experdia_car_rental_system.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO entity);

    List<CustomerDTO> getAllCustomer();

    void deleteCustomer(String id);

    void updateCustomer(CustomerDTO entity);

    CustomerDTO searchCustomer(String id);
}
