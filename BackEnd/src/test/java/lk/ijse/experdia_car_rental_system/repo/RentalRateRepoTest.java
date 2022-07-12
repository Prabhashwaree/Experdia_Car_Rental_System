package lk.ijse.experdia_car_rental_system.repo;

import lk.ijse.experdia_car_rental_system.config.JPAConfig;
import lk.ijse.experdia_car_rental_system.entity.RentalRate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)

public class RentalRateRepoTest {
    @Autowired
    RentalRateRepo rentalRateRepo;

    @Test
    public void getAllRentalRate(){
    }

    @Test
    public void saveRentalRate(){
        RentalRate rentalRate1 = new RentalRate(
                "R001",
                "2022-07-08",
                "4.00",
                "Genaral",
                "Suzuki Alto",
                "2500",
                "100",
                "2400",
                "64,350.00",
                "30.00"
        );
        RentalRate rentalRate2 = new RentalRate("R002", "2022-07-09", "6.00","Premium Cars", "Toyota","5500","100", "120,330.00","2400","49.50");
        rentalRateRepo.save(rentalRate1);
        rentalRateRepo.save(rentalRate2);
    }

    @Test
    public void deleteRentalRate(){
        rentalRateRepo.deleteById("R001");
    }

    @Test
    public void updateRentalRate(){
        if (rentalRateRepo.existsById("R002")) {
            RentalRate rentalRate = new RentalRate("R002", "2022-07-10", "10.00","Premium Cars", "Perodua","5500","100", "120,330.00","2400","49.50");
            rentalRateRepo.save(rentalRate);
        }else{
            throw new RuntimeException("No Such Rental Rate To Update.....");
        }
    }

    @Test
    public void searchRentalRate(){}
}
