package lk.ijse.experdia_car_rental_system.service.serviceImpl;

import lk.ijse.experdia_car_rental_system.dto.PaymentDTO;
import lk.ijse.experdia_car_rental_system.entity.Payment;
import lk.ijse.experdia_car_rental_system.repo.PaymentRepo;
import lk.ijse.experdia_car_rental_system.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void savePayment(PaymentDTO paymentDTO) {
        if(!paymentRepo.existsById(paymentDTO.getPayment_Id())){
            paymentRepo.save(modelMapper.map(paymentDTO, Payment.class));
        }else {
            throw new RuntimeException("Payment Already Exist..!");
        }
    }

    @Override
    public List<PaymentDTO> getAllPayment() {
        return modelMapper.map(paymentRepo.findAll(),new TypeToken<List<PaymentDTO>>(){}.getType());
    }

    @Override
    public void deletePayment(String id) {
        if(paymentRepo.existsById(id)){
            paymentRepo.deleteById(id);
        }else {
            throw new RuntimeException("Please check the Payment ID.. No Such Payment..!");
        }
    }

    @Override
    public void updatePayment(PaymentDTO paymentDTO) {
        if(paymentRepo.existsById(paymentDTO.getPayment_Id())){
            paymentRepo.save(modelMapper.map(paymentDTO,Payment.class));
        }else {
            throw new RuntimeException("No Such Payment To Update..! Please Check the ID..!");
        }
    }

    @Override
    public PaymentDTO searchPayment(String id) {
        if(paymentRepo.existsById(id)){
            return modelMapper.map(paymentRepo.findById(id).get(),PaymentDTO.class);
        }else {
            throw new RuntimeException("No Payment For "+id+" ..!");
        }
    }
}
