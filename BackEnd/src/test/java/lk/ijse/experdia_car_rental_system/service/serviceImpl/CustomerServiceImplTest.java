package lk.ijse.experdia_car_rental_system.service.serviceImpl;

import lk.ijse.experdia_car_rental_system.config.WebAppConfig;
import lk.ijse.experdia_car_rental_system.dto.CustomerDTO;
import lk.ijse.experdia_car_rental_system.entity.UserLogin;
import lk.ijse.experdia_car_rental_system.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class})
@ExtendWith(SpringExtension.class)
@Transactional

class CustomerServiceImplTest {
    @Autowired
    CustomerService customerService;

    public CustomerDTO addOneCustomer() {
        return new CustomerDTO(
                "C001",
                "L1548",
                "Samayansena",
                "Colombo",
                "078599860",
                "samayan@gmail.com",
                "2022-07-08",
                "4.00",
                new UserLogin(
                    "U001",
                    "neth",
                    "Admin",
                    "Nethmini"
                )
        );
    }

    @Test
    void saveCustomer() {
        CustomerDTO customerDTO = addOneCustomer();
        assertDoesNotThrow(() -> {
            customerService.saveCustomer(customerDTO);
        });
        CustomerDTO customerDTO2 =addOneCustomer();
        assertThrows(RuntimeException.class, () -> {
            customerService.saveCustomer(customerDTO2);
        });
    }

    @Test
    void getAllCustomer() {
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void searchCustomer() {
    }
}