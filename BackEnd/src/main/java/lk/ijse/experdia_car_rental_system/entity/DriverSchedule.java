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
@IdClass(BookingDriver_PK.class)

public class DriverSchedule {
    @Id
    private String booking_Id;
    @Id
    private String driver_NIC;
    private String date;
    private String time;
    private String status;

    @ManyToOne
    @JoinColumn(name = "booking_Id",referencedColumnName = "booking_Id",insertable = false,updatable = false)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "driver_NIC",referencedColumnName = "driver_NIC ",insertable = false,updatable = false)
    private Driver driver;
}
