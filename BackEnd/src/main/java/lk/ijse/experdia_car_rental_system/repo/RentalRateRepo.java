package lk.ijse.experdia_car_rental_system.repo;

import lk.ijse.experdia_car_rental_system.entity.RentalRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRateRepo extends JpaRepository<RentalRate,String> {
}
