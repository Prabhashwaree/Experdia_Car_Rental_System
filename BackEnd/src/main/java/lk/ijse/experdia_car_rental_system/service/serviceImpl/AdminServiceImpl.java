package lk.ijse.experdia_car_rental_system.service.serviceImpl;

import lk.ijse.experdia_car_rental_system.dto.AdminDTO;
import lk.ijse.experdia_car_rental_system.entity.Admin;
import lk.ijse.experdia_car_rental_system.repo.AdminRepo;
import lk.ijse.experdia_car_rental_system.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveAdmin(AdminDTO adminDTO) {
        if(!adminRepo.existsById(adminDTO.getAdmin_Id())){
            adminRepo.save(modelMapper.map(adminDTO, Admin.class));
        }else {
            throw new RuntimeException("Admin Already Exist..!");
        }
    }

    @Override
    public List<AdminDTO> getAllAdmin() {
        return modelMapper.map(adminRepo.findAll(),new TypeToken<List<AdminDTO>>(){}.getType());
    }

    @Override
    public void deleteAdmin(String id) {
        if(adminRepo.existsById(id)){
            adminRepo.deleteById(id);
        }else {
            throw new RuntimeException("Please check the Admin ID.. No Such Admin..!");
        }
    }

    @Override
    public void updateAdmin(AdminDTO adminDTO) {
        if(adminRepo.existsById(adminDTO.getAdmin_Id())){
            adminRepo.save(modelMapper.map(adminDTO, Admin.class));
        }else {
            throw new RuntimeException("No Such Admin To Update..! Please Check the ID..!");
        }
    }

    @Override
    public AdminDTO searchAdmin(String id) {
        if(adminRepo.existsById(id)){
            return modelMapper.map(adminRepo.findById(id).get(),AdminDTO.class);
        }else {
            throw new RuntimeException("No Admin For "+id+" ..!");
        }
    }
}
