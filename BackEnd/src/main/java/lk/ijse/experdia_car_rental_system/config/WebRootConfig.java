package lk.ijse.experdia_car_rental_system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JPAConfig.class)

public class WebRootConfig {

}