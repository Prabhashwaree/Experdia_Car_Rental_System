package lk.ijse.experdia_car_rental_system.repo;

import lk.ijse.experdia_car_rental_system.entity.DriverSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverScheduleRepo extends JpaRepository<DriverSchedule,String> {
}
