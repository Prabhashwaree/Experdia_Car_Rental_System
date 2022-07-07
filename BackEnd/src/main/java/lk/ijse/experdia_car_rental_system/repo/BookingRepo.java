package lk.ijse.experdia_car_rental_system.repo;

import lk.ijse.experdia_car_rental_system.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking,String> {
}
