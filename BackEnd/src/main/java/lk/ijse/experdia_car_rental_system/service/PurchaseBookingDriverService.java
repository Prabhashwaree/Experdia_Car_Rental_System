package lk.ijse.experdia_car_rental_system.service;


import lk.ijse.experdia_car_rental_system.dto.BookingDTO;

import java.util.List;

public interface PurchaseBookingDriverService {
    void savePurchaseBooking(BookingDTO entity);

    List<BookingDTO> getAllPurchaseBooking();

    void deletePurchaseBooking(String id);

    void updatePurchaseBooking(BookingDTO entity);

    BookingDTO searchPurchaseBooking(String id);


}
