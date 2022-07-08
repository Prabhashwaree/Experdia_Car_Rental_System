package lk.ijse.experdia_car_rental_system.service;

import lk.ijse.experdia_car_rental_system.dto.UserLoginDTO;

import java.util.List;

public interface UserLoginService {
    void saveUserLogin(UserLoginDTO entity);

    List<UserLoginDTO> getAllUserLogin();

    void deleteUserLogin(String id);

    void updateUserLogin(UserLoginDTO entity);

    UserLoginDTO searchUserLogin(String id);
}
