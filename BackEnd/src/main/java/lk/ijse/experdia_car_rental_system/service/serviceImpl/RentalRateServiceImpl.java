package lk.ijse.experdia_car_rental_system.service.serviceImpl;

import lk.ijse.experdia_car_rental_system.dto.RentalRateDTO;
import lk.ijse.experdia_car_rental_system.entity.RentalRate;
import lk.ijse.experdia_car_rental_system.repo.RentalRateRepo;
import lk.ijse.experdia_car_rental_system.service.RentalRateService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class RentalRateServiceImpl implements RentalRateService {

    @Autowired
    RentalRateRepo rentalRateRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveRentalRate(RentalRateDTO rentalRateDTO) {
        if(!rentalRateRepo.existsById(rentalRateDTO.getRate_Id())){
            rentalRateRepo.save(modelMapper.map(rentalRateDTO, RentalRate.class));
        }else {
            throw new RuntimeException("RentalRate Already Exist..!");
        }
    }

    @Override
    public List<RentalRateDTO> getAllRentalRate() {
        return modelMapper.map(rentalRateRepo.findAll(),new TypeToken<List<RentalRateDTO>>(){}.getType());
    }

    @Override
    public void deleteRentalRate(String id) {
        if(rentalRateRepo.existsById(id)){
            rentalRateRepo.deleteById(id);
        }else {
            throw new RuntimeException("Please check the RentalRate ID.. No Such RentalRate..!");
        }
    }

    @Override
    public void updateRentalRate(RentalRateDTO rentalRateDTO) {
        if(rentalRateRepo.existsById(rentalRateDTO.getRate_Id())){
            rentalRateRepo.save(modelMapper.map(rentalRateDTO,RentalRate.class));
        }else {
            throw new RuntimeException("No Such User To Update..! Please Check the ID..!");
        }
    }

    @Override
    public RentalRateDTO searchRentalRate(String id) {
        if(rentalRateRepo.existsById(id)){
            return modelMapper.map(rentalRateRepo.findById(id).get(),RentalRateDTO.class);
        }else {
            throw new RuntimeException("No RentalRate For "+id+" ..!");
        }
    }
}
