package lk.ijse.experdia_car_rental_system.dto;

import lk.ijse.experdia_car_rental_system.entity.BookingDetails;
import lk.ijse.experdia_car_rental_system.entity.Customer;
import lk.ijse.experdia_car_rental_system.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class BookingDTO {
    private String booking_Id;
    private String picUp_Date;
    private String drop_Date;
    private String picUp_Time;
    private String drop_Time;
    private String bookingStatus;
    private String driverStatus;
    private String picUpLocation;
    private double lossDamagePrice;
    private String rent_Duration;
    private String car_Count;

    private Customer customer;
    private Payment payment;

    private List<BookingDetailsDTO> bookingDetailsDTO;
    private List<DriverScheduleDTO> driverScheduleDTO;
}
