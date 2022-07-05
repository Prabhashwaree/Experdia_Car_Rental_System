package lk.ijse.experdia_car_rental_system.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("lk.ijse.experdia_car_rental_system")
@EnableWebMvc

public class WebAppConfig {

    @Bean
    public ModelMapper modelMapper(){

        return new ModelMapper();
    }
}
