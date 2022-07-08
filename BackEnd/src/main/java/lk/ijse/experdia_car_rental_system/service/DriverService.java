package lk.ijse.experdia_car_rental_system.service;

import lk.ijse.experdia_car_rental_system.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    void saveDriver(DriverDTO entity);

    List<DriverDTO> getAllDriver();

    void deleteDriver(String id);

    void updateDriver(DriverDTO entity);

    DriverDTO searchDriver(String id);
}
