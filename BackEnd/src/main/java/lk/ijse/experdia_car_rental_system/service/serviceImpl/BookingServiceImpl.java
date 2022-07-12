package lk.ijse.experdia_car_rental_system.service.serviceImpl;

import lk.ijse.experdia_car_rental_system.dto.BookingDTO;
import lk.ijse.experdia_car_rental_system.entity.Booking;
import lk.ijse.experdia_car_rental_system.repo.BookingRepo;
import lk.ijse.experdia_car_rental_system.service.BookingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class BookingServiceImpl  implements BookingService{

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveBooking(BookingDTO bookingDTO) {
        if(!bookingRepo.existsById(bookingDTO.getBooking_Id())){
            bookingRepo.save(modelMapper.map(bookingDTO, Booking.class));
        }else {
            throw new RuntimeException("Booking Already Exist..!");
        }
    }

    @Override
    public List<BookingDTO> getAllBooking() {
        return modelMapper.map(bookingRepo.findAll(),new TypeToken<List<BookingDTO>>(){}.getType());
    }

    @Override
    public void deleteBooking(String id) {
        if(bookingRepo.existsById(id)){
            bookingRepo.deleteById(id);
        }else {
            throw new RuntimeException("Please check the Booking ID.. No Such Booking..!");
        }
    }

    @Override
    public void updateBooking(BookingDTO bookingDTO) {
        if(bookingRepo.existsById(bookingDTO.getBooking_Id())){
            bookingRepo.save(modelMapper.map(bookingDTO,Booking.class));
        }else {
            throw new RuntimeException("No Such Booking To Update..! Please Check the ID..!");
        }
    }

    @Override
    public BookingDTO searchBooking(String id) {
        if(bookingRepo.existsById(id)){
            return modelMapper.map(bookingRepo.findById(id).get(),BookingDTO.class);
        }else {
            throw new RuntimeException("No Booking For "+id+" ..!");
        }
    }
}
