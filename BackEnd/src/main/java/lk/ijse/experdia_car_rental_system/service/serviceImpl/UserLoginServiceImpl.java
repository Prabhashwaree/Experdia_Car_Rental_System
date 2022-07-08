package lk.ijse.experdia_car_rental_system.service.serviceImpl;

import lk.ijse.experdia_car_rental_system.dto.UserLoginDTO;
import lk.ijse.experdia_car_rental_system.entity.UserLogin;
import lk.ijse.experdia_car_rental_system.repo.UserLoginRepo;
import lk.ijse.experdia_car_rental_system.service.UserLoginService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    UserLoginRepo userLoginRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveUserLogin(UserLoginDTO userLoginDTO) {
        if(!userLoginRepo.existsById(userLoginDTO.getUser_Id())){
            userLoginRepo.save(modelMapper.map(userLoginDTO, UserLogin.class));
        }else {
            throw new RuntimeException("User Already Exist..!");
        }
    }

    @Override
    public List<UserLoginDTO> getAllUserLogin() {
        return modelMapper.map(userLoginRepo.findAll(),new TypeToken<List<UserLoginDTO>>(){}.getType());
    }

    @Override
    public void deleteUserLogin(String id) {
        if(userLoginRepo.existsById(id)){
            userLoginRepo.deleteById(id);
        }else {
            throw new RuntimeException("Please check the User ID.. No Such UserLogin..!");
        }
    }

    @Override
    public void updateUserLogin(UserLoginDTO userLoginDTO) {
        if(userLoginRepo.existsById(userLoginDTO.getUser_Id())){
            userLoginRepo.save(modelMapper.map(userLoginDTO,UserLogin.class));
        }else {
            throw new RuntimeException("No Such User To Update..! Please Check the ID..!");
        }
    }

    @Override
    public UserLoginDTO searchUserLogin(String id) {
        if(userLoginRepo.existsById(id)){
            return modelMapper.map(userLoginRepo.findById(id).get(),UserLoginDTO.class);
        }else {
            throw new RuntimeException("No User For "+id+" ..!");
        }
    }
}
