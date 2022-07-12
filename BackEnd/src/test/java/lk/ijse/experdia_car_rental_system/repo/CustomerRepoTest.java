package lk.ijse.experdia_car_rental_system.repo;

import lk.ijse.experdia_car_rental_system.config.JPAConfig;
import lk.ijse.experdia_car_rental_system.dto.CustomerDTO;
import lk.ijse.experdia_car_rental_system.entity.Customer;
import lk.ijse.experdia_car_rental_system.entity.UserLogin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)

class CustomerRepoTest {
    @Autowired
    CustomerRepo customerRepo;

    @Test
    public void addOneCustomer() {
        Customer customer = new Customer(
//                "C001",
//                "L1548",
//                "Samayansena",
//                "Colombo",
//                "078599860",
//                "samayan@gmail.com",
//                "2022-07-08",
//                "4.00",
//                new UserLogin(
//                        "U001",
//                        "neth",
//                        "Admin",
//                        "Nethmini"
//                )
        );
        customerRepo.save(customer);
    }


}