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

public class Customer {
    @Id
    private String nIC_No;
    private String license_Id;
    private String cus_Name;
    private String address;
    private String contact_No;
    private String email;
    private String date;
    private String time;

    @OneToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "userdID",referencedColumnName = "user_Id",nullable = false)
    private UserLogin userLogin;
}



