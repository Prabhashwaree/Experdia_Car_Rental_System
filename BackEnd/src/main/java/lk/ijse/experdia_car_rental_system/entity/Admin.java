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

public class Admin {
    @Id
    private String admin_Id;
    private String admin_Name;
    private String admin_Contact;

    @OneToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "u_ID",referencedColumnName = "user_Id",nullable = false)
    private UserLogin userLogin;

}


