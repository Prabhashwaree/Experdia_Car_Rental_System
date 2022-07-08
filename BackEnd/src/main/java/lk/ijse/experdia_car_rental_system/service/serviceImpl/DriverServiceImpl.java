package lk.ijse.experdia_car_rental_system.service.serviceImpl;

import lk.ijse.experdia_car_rental_system.dto.DriverDTO;
import lk.ijse.experdia_car_rental_system.entity.Driver;
import lk.ijse.experdia_car_rental_system.repo.DriverRepo;
import lk.ijse.experdia_car_rental_system.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveDriver(DriverDTO driverDTO) {
        if(!driverRepo.existsById(driverDTO.getDriver_NIC())){
            driverRepo.save(modelMapper.map(driverDTO, Driver.class));
        }else {
            throw new RuntimeException("Driver Already Exist..!");
        }
    }

    @Override
    public List<DriverDTO> getAllDriver() {
        return modelMapper.map(driverRepo.findAll(),new TypeToken<List<DriverDTO>>(){}.getType());
    }

    @Override
    public void deleteDriver(String id) {
        if(driverRepo.existsById(id)){
            driverRepo.deleteById(id);
        }else {
            throw new RuntimeException("Please check the Driver ID.. No Such Driver..!");
        }
    }

    @Override
    public void updateDriver(DriverDTO driverDTO) {
        if(driverRepo.existsById(driverDTO.getDriver_NIC())){
            driverRepo.save(modelMapper.map(driverDTO,Driver.class));
        }else {
            throw new RuntimeException("No Such Driver To Update..! Please Check the ID..!");
        }
    }

    @Override
    public DriverDTO searchDriver(String id) {
        if(driverRepo.existsById(id)){
            return modelMapper.map(driverRepo.findById(id).get(),DriverDTO.class);
        }else {
            throw new RuntimeException("No Driver For "+id+" ..!");
        }
    }
}
