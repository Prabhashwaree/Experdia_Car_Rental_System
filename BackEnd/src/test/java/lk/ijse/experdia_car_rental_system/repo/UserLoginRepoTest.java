package lk.ijse.experdia_car_rental_system.repo;

import lk.ijse.experdia_car_rental_system.config.JPAConfig;
import lk.ijse.experdia_car_rental_system.entity.UserLogin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)

public class UserLoginRepoTest {
    @Autowired
    UserLoginRepo userLoginRepo;

    @Test
    public void getAllUserLogin(){
    }

    @Test
    public void saveUserLogin(){
        UserLogin userLogin1 = new UserLogin("U001", "Admin", "Nethmini", "neth");
        UserLogin userLogin2 = new UserLogin("U002", "Customer", "Gayathree", "gaya");
        userLoginRepo.save(userLogin1);
        userLoginRepo.save(userLogin2);
    }

    @Test
    public void deleteUserLogin(){
        userLoginRepo.deleteById("U001");
    }

    @Test
    public void updateUserLogin(){
        if (userLoginRepo.existsById("U002")) {
            UserLogin userLogin = new UserLogin("U002", "Customer", "Silva", "silva");
            userLoginRepo.save(userLogin);
        }else{
            throw new RuntimeException("No Such User Login To Update.....");
        }
    }

    @Test
    public void searchUserLogin(){}
}
