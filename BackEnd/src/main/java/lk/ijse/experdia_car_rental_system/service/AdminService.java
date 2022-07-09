package lk.ijse.experdia_car_rental_system.service;

import lk.ijse.experdia_car_rental_system.dto.AdminDTO;

import java.util.List;

public interface AdminService {
    void saveAdmin(AdminDTO entity);

    List<AdminDTO> getAllAdmin();

    void deleteAdmin(String id);

    void updateAdmin(AdminDTO entity);

    AdminDTO searchAdmin(String id);
}
