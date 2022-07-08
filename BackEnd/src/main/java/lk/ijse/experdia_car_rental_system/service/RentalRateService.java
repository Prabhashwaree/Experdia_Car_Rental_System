package lk.ijse.experdia_car_rental_system.service;

import lk.ijse.experdia_car_rental_system.dto.RentalRateDTO;


import java.util.List;

public interface RentalRateService {
    void saveRentalRate(RentalRateDTO entity);

    List<RentalRateDTO> getAllRentalRate();

    void deleteRentalRate(String id);

    void updateRentalRate(RentalRateDTO entity);

    RentalRateDTO searchRentalRate(String id);
}
