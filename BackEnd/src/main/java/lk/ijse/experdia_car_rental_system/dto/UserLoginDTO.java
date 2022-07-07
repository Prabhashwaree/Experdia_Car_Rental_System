package lk.ijse.experdia_car_rental_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class UserLoginDTO {

    private String user_Id;
    private String type;
    private String user_Name;
    private String password;
}
