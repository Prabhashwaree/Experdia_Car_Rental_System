package lk.ijse.experdia_car_rental_system.repo;

import lk.ijse.experdia_car_rental_system.config.JPAConfig;
import lk.ijse.experdia_car_rental_system.entity.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;


@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)

public class DriverScheduleRepoTest {
    @Autowired
    DriverScheduleRepo driverScheduleRepo;

    @Test
    public void getAllDriverSchedule(){
    }


    @Test
    public void saveDriverSchedule(){
//        DriverSchedule driverSchedule = new DriverSchedule(
//                "B001",
//                "995867816V",
//                "2022-07-08",
//                "8.00",
//                "Comfirm",
//                new Booking(
//                        "B001",
//                        "2022-07-08",
//                        "2022-07-09",
//                        "8.00",
//                        "4.00",
//                        "confirm",
//                        "No Driver",
//                        "Panadura",
//                        10000,
//                        "1",
//                        "1",
//                        new Customer(
//                                "995687458V",
//                                "L5778",
//                                "Nethmini",
//                                "Kaluthara",
//                                "0779845875",
//                                "neth@gmail.com",
//                                "2022-07-08",
//                                "8.00",
//                                new UserLogin(
//                                        "U001",
//                                        "Admin",
//                                        "Nethmini",
//                                        "neth"
//                                )
//                        ),
//                        new Payment(
//                                "P001",
//                                "2022-07-08",
//                                "8.00",
//                                "400",
//                                "1500",
//                                "1100",
//                                "confirm",
//                                4000
//                        ),
//                        new BookingDetails(
//                                "B001",
//                                "C001",
//                                "2022-07-08",
//                                "8.00",
//                                new Booking(
//                                        "B001",
//                                        "2022-07-08",
//                                        "2022-07-09",
//                                        "8.00",
//                                        "4.00",
//                                        "confirm",
//                                        "No Driver",
//                                        "Panadura",
//                                        10000,
//                                        "1",
//                                        "1",
//                                        "",
//                                        "",
//                                        ""
//                                ),
//                                ""
//                        )
//                ),
//                ""
//
//        );
//
//
//
//        driverScheduleRepo.save(driverSchedule);

    }

    @Test
    public void deleteDriverSchedule(){
        driverScheduleRepo.deleteById("P001");
    }

}
