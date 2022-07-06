package lk.ijse.experdia_car_rental_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class Booking {
    @Id
    private String booking_Id;
    private String picUp_Date;
    private String drop_Date;
    private String picUp_Time;
    private String drop_Time;
    private String bookingStatus;
    private String driverStatus;
    private String picUpLocation;
    private String lossDamagePrice;
    private String rent_Duration;
    private String car_Count;


}

