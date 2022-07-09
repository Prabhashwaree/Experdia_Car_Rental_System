package lk.ijse.experdia_car_rental_system.service.serviceImpl;

import lk.ijse.experdia_car_rental_system.dto.BookingDTO;
import lk.ijse.experdia_car_rental_system.entity.Booking;
import lk.ijse.experdia_car_rental_system.entity.Driver;
import lk.ijse.experdia_car_rental_system.entity.DriverSchedule;
import lk.ijse.experdia_car_rental_system.repo.BookingRepo;
import lk.ijse.experdia_car_rental_system.repo.DriverRepo;
import lk.ijse.experdia_car_rental_system.repo.DriverScheduleRepo;
import lk.ijse.experdia_car_rental_system.service.PurchaseBookingDriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service

public class PurchaseBookingDriverServiceImpl implements PurchaseBookingDriverService{

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    DriverScheduleRepo driverScheduleRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public void savePurchaseBooking(BookingDTO bookingDTO) {
        Booking booking = modelMapper.map(bookingDTO, Booking.class);
        if (!bookingRepo.existsById(bookingDTO.getBooking_Id())) {
            bookingRepo.save(booking);
            if(bookingDTO.getDriverScheduleDTO().size()<1)throw new RuntimeException("No Driver added for the Booking..!");


            //Update the driver-----
            for(DriverSchedule driverSchedule:booking.getDriverSchedule()){
                Driver driver = driverRepo.findById(driverSchedule.getDriver_NIC()).get();
                driverRepo.save(driver);
            }

        }else {
            throw new RuntimeException("Purchase Booking Failed..!, Booking ID " + bookingDTO.getBooking_Id() + " Already Exist.!");
        }
    }

    @Override
    public List<BookingDTO> getAllPurchaseBooking() {
        return modelMapper.map(bookingRepo.findAll(),new TypeToken<List<BookingDTO>>(){}.getType());
    }

    @Override
    public void deletePurchaseBooking(String bid) {
        if(bookingRepo.existsById(bid)) {
            bookingRepo.deleteById(bid);
        }else {
            throw new RuntimeException("Delete Booking Failed..!, Booking ID " + bid + " Not Exist..!");
        }
    }

    @Override
    public void updatePurchaseBooking(BookingDTO bookingDTO) {
        if(bookingRepo.existsById(bookingDTO.getBooking_Id())){
            Booking booking = modelMapper.map(bookingDTO, Booking.class);

            if(bookingDTO.getDriverScheduleDTO().size()<1)throw new RuntimeException("No driver added for the Booking..!");{
                for(DriverSchedule driverSchedule:booking.getDriverSchedule()){
                    Driver driver = driverRepo.findById(driverSchedule.getDriver_NIC()).get();
                    //DriverSchedule driverSchedule1 = driverScheduleRepo.findById(String.valueOf(new BookingDriver_PK(driverSchedule.getBooking_Id(),driverSchedule.getDriver_NIC()))).get();

                    driverRepo.save(driver);

                }
                //then delete the old booking
                bookingRepo.deleteById(bookingDTO.getBooking_Id());
                //finally update the new booking
                bookingRepo.save(booking);
            }

        }else{
            throw new RuntimeException("Update Booking Failed..!, Booking ID " + bookingDTO.getBooking_Id() + " Not Exist.!");


        }
    }

    @Override
    public BookingDTO searchPurchaseBooking(String id) {
        return null;
    }
}
