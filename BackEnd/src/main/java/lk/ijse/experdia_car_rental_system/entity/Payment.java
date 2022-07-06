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

public class Payment {
    @Id
    private String payment_Id;
    private String date;
    private String time;
    private String currently_Run_KM;
    private String ride_A_KM;
    private String total_KM;
    private String status;
    private double total_Price;
}


