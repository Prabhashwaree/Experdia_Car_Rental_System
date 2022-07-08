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
    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookingDetails> bookingDetails;




    public Booking(String booking_Id, String picUp_Date, String drop_Date, String picUp_Time, String drop_Time, String bookingStatus, String driverStatus, String picUpLocation, double lossDamagePrice, String rent_Duration, String car_Count, Customer customer, Payment payment) {
        this.booking_Id = booking_Id;
        this.picUp_Date = picUp_Date;
        this.drop_Date = drop_Date;
        this.picUp_Time = picUp_Time;
        this.drop_Time = drop_Time;
        this.bookingStatus = bookingStatus;
        this.driverStatus = driverStatus;
        this.picUpLocation = picUpLocation;
        this.lossDamagePrice = lossDamagePrice;
        this.rent_Duration = rent_Duration;
        this.car_Count = car_Count;
        this.customer = customer;
        this.payment = payment;
    }


}

