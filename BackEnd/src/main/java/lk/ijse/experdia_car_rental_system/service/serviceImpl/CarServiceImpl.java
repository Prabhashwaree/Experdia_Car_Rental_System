package lk.ijse.experdia_car_rental_system.service.serviceImpl;

import lk.ijse.experdia_car_rental_system.dto.CarDTO;
import lk.ijse.experdia_car_rental_system.entity.Car;
import lk.ijse.experdia_car_rental_system.repo.CarRepo;
import lk.ijse.experdia_car_rental_system.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class CarServiceImpl implements CarService {
    @Autowired
    CarRepo carRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveCar(CarDTO carDTO) {
        if(!carRepo.existsById(carDTO.getRegister_No())){
            carRepo.save(modelMapper.map(carDTO, Car.class));
        }else {
            throw new RuntimeException("Car Already Exist..!");
        }
    }

    @Override
    public List<CarDTO> getAllCar() {
        return modelMapper.map(carRepo.findAll(),new TypeToken<List<CarDTO>>(){}.getType());
    }

    @Override
    public void deleteCar(String id) {
        if(carRepo.existsById(id)){
            carRepo.deleteById(id);
        }else {
            throw new RuntimeException("Please check the Car ID.. No Such Car..!");
        }
    }

    @Override
    public void updateCar(CarDTO carDTO) {
        if(carRepo.existsById(carDTO.getRegister_No())){
            carRepo.save(modelMapper.map(carDTO, Car.class));
        }else {
            throw new RuntimeException("No Such Car To Update..! Please Check the ID..!");
        }
    }

    @Override
    public CarDTO searchCar(String id) {
        if(carRepo.existsById(id)){
            return modelMapper.map(carRepo.findById(id).get(),CarDTO.class);
        }else {
            throw new RuntimeException("No Car For "+id+" ..!");
        }
    }
}
