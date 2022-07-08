package lk.ijse.experdia_car_rental_system.service.serviceImpl;

import lk.ijse.experdia_car_rental_system.dto.CustomerDTO;
import lk.ijse.experdia_car_rental_system.entity.Customer;
import lk.ijse.experdia_car_rental_system.repo.CustomerRepo;
import lk.ijse.experdia_car_rental_system.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        if(!customerRepo.existsById(customerDTO.getNIC_No())){
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
        }else {
            throw new RuntimeException("Customer Already Exist..!");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return modelMapper.map(customerRepo.findAll(),new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    @Override
    public void deleteCustomer(String id) {
        if(customerRepo.existsById(id)){
            customerRepo.deleteById(id);
        }else {
            throw new RuntimeException("Please check the Customer ID.. No Such Customer..!");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        if(customerRepo.existsById(customerDTO.getNIC_No())){
            customerRepo.save(modelMapper.map(customerDTO,Customer.class));
        }else {
            throw new RuntimeException("No Such Customer To Update..! Please Check the ID..!");
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        if(customerRepo.existsById(id)){
            return modelMapper.map(customerRepo.findById(id).get(),CustomerDTO.class);
        }else {
            throw new RuntimeException("No Booking For "+id+" ..!");
        }
    }
}
