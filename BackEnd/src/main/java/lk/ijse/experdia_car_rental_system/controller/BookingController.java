package lk.ijse.experdia_car_rental_system.controller;

import lk.ijse.experdia_car_rental_system.dto.BookingDTO;
import lk.ijse.experdia_car_rental_system.service.BookingService;
import lk.ijse.experdia_car_rental_system.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Booking")
@CrossOrigin

public class BookingController {
    @Autowired
    BookingService bookingService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil saveBooking(@RequestBody BookingDTO bookingDTO){
        bookingService.saveBooking(bookingDTO);
        return new ResponceUtil(200,"save",null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil getAllBooking(){
        return  new ResponceUtil(200,"getAll",bookingService.getAllBooking());
    }

    @DeleteMapping(params = {"booking_Id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil deleteBooking(@RequestParam("booking_Id") String id){
        bookingService.deleteBooking(id);
        return new ResponceUtil(200,"deleted",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil updateBooking(@RequestBody BookingDTO bookingDTO){
        bookingService.updateBooking(bookingDTO);
        return new ResponceUtil(200,"updated",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil searchBooking(@PathVariable String id){
        return new ResponceUtil(200,"search",bookingService.searchBooking(id));
    }
}
