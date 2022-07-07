package lk.ijse.experdia_car_rental_system.dto;

import lk.ijse.experdia_car_rental_system.entity.RentalRate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class CarDTO {
    private String register_No;
    private String date;
    private String time;
    private String brand;
    private String type;
    private String no_Passenger;
    private String transmission_Type;
    private String fuel;
    private String colour;
    private double lossDamagePrice;
    private RentalRate rentalRate;
}
