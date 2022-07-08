package lk.ijse.experdia_car_rental_system.repo;

import lk.ijse.experdia_car_rental_system.config.JPAConfig;
import lk.ijse.experdia_car_rental_system.entity.Driver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)

public class DriverRepoTest {
    @Autowired
    DriverRepo driverRepo;

    @Test
    public void getAllDriver(){
    }


    @Test
    public void saveDriver(){
        Driver driver1 = new Driver(
                "995867816V",
                "2022-07-08",
                "4.00",
                "L2548",
                "neth",
                "panadura",
                "0785548765",
                "25000"
        );
        driverRepo.save(driver1);

    }

    @Test
    public void deleteDriver(){
        driverRepo.deleteById("995867816V");
    }

    @Test
    public void updateDriver(){
        if (driverRepo.existsById("968957458V")) {
            Driver driver = new Driver("968957458V","2022-07-09", "4.00","L2548","neth gaya","kaluthara","0785548765","25000");
            driverRepo.save(driver);
        }else{
            throw new RuntimeException("No Such Driver To Update.....");
        }
    }

    @Test
    public void searchDriverSchedule(){}
}
