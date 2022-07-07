package lk.ijse.experdia_car_rental_system.repo;

import lk.ijse.experdia_car_rental_system.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver,String> {
}
