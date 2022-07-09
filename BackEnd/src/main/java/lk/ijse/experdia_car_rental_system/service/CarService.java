package lk.ijse.experdia_car_rental_system.service;

import lk.ijse.experdia_car_rental_system.dto.CarDTO;

import java.util.List;

public interface CarService {
    void saveCar(CarDTO entity);

    List<CarDTO> getAllCar();

    void deleteCar(String id);

    void updateCar(CarDTO entity);

    CarDTO searchCar(String id);
}
