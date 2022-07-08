package lk.ijse.experdia_car_rental_system.service;

import lk.ijse.experdia_car_rental_system.dto.PaymentDTO;


import java.util.List;

public interface PaymentService {
    void savePayment(PaymentDTO entity);

    List<PaymentDTO> getAllPayment();

    void deletePayment(String id);

    void updatePayment(PaymentDTO entity);

    PaymentDTO searchPayment(String id);
}
