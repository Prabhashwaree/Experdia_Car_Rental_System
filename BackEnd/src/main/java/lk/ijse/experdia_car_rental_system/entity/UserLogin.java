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

public class UserLogin {
    @Id
    private String user_Id;
    private String type;
    private String user_Name;
    private String password;
}
