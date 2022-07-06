package lk.ijse.experdia_car_rental_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class Car {
    @Id
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

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "r_Id",referencedColumnName = "rate_Id",nullable = false)
    private RentalRate rentalRate;
}
