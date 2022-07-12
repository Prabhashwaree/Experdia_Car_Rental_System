package lk.ijse.experdia_car_rental_system.service;

import lk.ijse.experdia_car_rental_system.dto.BookingDTO;

import java.util.List;

public interface BookingService {
    void saveBooking(BookingDTO entity);

    List<BookingDTO> getAllBooking();

    void deleteBooking(String id);

    void updateBooking(BookingDTO entity);

    BookingDTO searchBooking(String id);
}
