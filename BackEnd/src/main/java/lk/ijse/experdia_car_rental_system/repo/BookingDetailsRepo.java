package lk.ijse.experdia_car_rental_system.repo;

import lk.ijse.experdia_car_rental_system.entity.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDetailsRepo extends JpaRepository<BookingDetails,String> {
}
