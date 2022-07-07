package lk.ijse.experdia_car_rental_system.dto;

import lk.ijse.experdia_car_rental_system.entity.UserLogin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class CustomerDTO {
    private String nIC_No;
    private String license_Id;
    private String cus_Name;
    private String address;
    private String contact_No;
    private String email;
    private String date;
    private String time;
    private UserLogin userLogin;
}
