package lk.ijse.experdia_car_rental_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class BookingDetailsDTO {
    private String booking_Id;
    private String register_No;
    private String date;
    private String time;
}
