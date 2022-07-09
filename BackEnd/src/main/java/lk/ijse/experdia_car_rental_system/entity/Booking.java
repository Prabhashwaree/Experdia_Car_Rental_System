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

public class Booking {
    @Id
    private String booking_Id;
    private String picUp_Date;
    private String drop_Date;
    private String picUp_Time;
    private String drop_Time;
    private String bookingStatus;
    private String driverStatus;
    private String picUpLocation;
    private double lossDamagePrice;
    private String rent_Duration;
    private String car_Count;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "nIC",referencedColumnName = "nIC_No",nullable = false)
    private Customer customer;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "pay_Id",referencedColumnName = "payment_Id",nullable = false)
    private Payment payment;

    //booking and car
    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
    private List<BookingDetails> bookingDetails;


    //booking and driver
    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
    private List<DriverSchedule> driverSchedule;



}

