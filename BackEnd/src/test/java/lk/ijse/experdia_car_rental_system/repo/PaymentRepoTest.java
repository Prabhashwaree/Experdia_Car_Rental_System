package lk.ijse.experdia_car_rental_system.repo;

import lk.ijse.experdia_car_rental_system.config.JPAConfig;
import lk.ijse.experdia_car_rental_system.entity.Payment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)

public class PaymentRepoTest {
    @Autowired
    PaymentRepo paymentRepo;

    @Test
    public void getAllPayment(){
    }

    @Test
    public void savePayment(){
        Payment payment1 = new Payment(
                "P001",
                "2022-07-08",
                "4.00",
                "400",
                "1500",
                "1100",
                "confirm",
                4000
        );
        Payment payment2 = new Payment("P002", "2022-07-09", "4.00", "400", "1500", "1100", "cancle", 4000);
        paymentRepo.save(payment1);
        paymentRepo.save(payment2);
    }

    @Test
    public void deletePayment(){
        paymentRepo.deleteById("P001");
    }

    @Test
    public void updatePayment(){
        if (paymentRepo.existsById("P002")) {
            Payment payment = new Payment("P002", "2022-07-09", "4.00", "500", "1500", "1000", "cancle", 2000);
            paymentRepo.save(payment);
        }else{
            throw new RuntimeException("No Such Payment To Update.....");
        }
    }

    @Test
    public void searchPayment(){}
}
