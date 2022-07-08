package lk.ijse.experdia_car_rental_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class Driver {
    @Id
    private String driver_NIC;
    private String date;
    private String time;
    private String licen;
    private String name;
    private String address;
    private String contact_No;
    private String salary;

    //booking and driver
    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DriverSchedule> driverSchedule;


    public Driver(String driver_NIC, String date, String time, String licen, String name, String address, String contact_No, String salary) {
        this.driver_NIC = driver_NIC;
        this.date = date;
        this.time = time;
        this.licen = licen;
        this.name = name;
        this.address = address;
        this.contact_No = contact_No;
        this.salary = salary;
    }
}


