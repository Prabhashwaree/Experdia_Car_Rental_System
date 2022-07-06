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
@IdClass(BookingCar_PK.class)

public class BookingDetails {
    @Id
    private String booking_Id;
    @Id
    private String register_No;
    private String date;
    private String time;

    @ManyToOne
    @JoinColumn(name = "booking_Id",referencedColumnName = "booking_Id",insertable = false,updatable = false)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "register_No",referencedColumnName = "register_No ",insertable = false,updatable = false)
    private Car car;
}
