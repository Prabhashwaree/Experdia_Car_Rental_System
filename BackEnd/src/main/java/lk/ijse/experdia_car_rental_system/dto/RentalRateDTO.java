package lk.ijse.experdia_car_rental_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class RentalRateDTO {
    private String rate_Id;
    private String date;
    private String time;
    private String Brand;
    private String type;
    private String daily_Rate;
    private String free_KM_Day;
    private String free_KM_Month;
    private String monthly_Rate;
    private String pricePerExtraKM;
}
