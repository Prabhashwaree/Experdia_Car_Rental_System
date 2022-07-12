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

public class RentalRate {
    @Id
    private String rate_Id;
    private String date;
    private String time;
    private String brand;
    private String type;
    private String daily_Rate;
    private String free_KM_Day;
    private String free_KM_Month;
    private String monthly_Rate;
    private String pricePerExtraKM;

}

