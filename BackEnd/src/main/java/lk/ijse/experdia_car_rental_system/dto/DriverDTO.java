package lk.ijse.experdia_car_rental_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class DriverDTO {
    private String driver_NIC;
    private String date;
    private String time;
    private String licen;
    private String name;
    private String address;
    private String contact_No;
    private String salary;
}
