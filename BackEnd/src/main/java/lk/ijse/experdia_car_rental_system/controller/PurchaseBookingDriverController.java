package lk.ijse.experdia_car_rental_system.controller;


import lk.ijse.experdia_car_rental_system.dto.BookingDTO;
import lk.ijse.experdia_car_rental_system.service.PurchaseBookingDriverService;
import lk.ijse.experdia_car_rental_system.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("PurchaseBookingDriver")
@CrossOrigin

public class PurchaseBookingDriverController {
    @Autowired
    PurchaseBookingDriverService purchaseBookingDriverService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil getAllPurchaseBookingDriver(){
        return new ResponceUtil(200,"getAllPurchase Booking..",purchaseBookingDriverService.getAllPurchaseBooking());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil savePurchaseBookingDriver(@RequestBody BookingDTO bookingDTO){
        System.out.println(bookingDTO.toString());
        purchaseBookingDriverService.savePurchaseBooking(bookingDTO);
        return new ResponceUtil(200,"savePurchase booking..",null);

    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil updatePurchaseBookingDriver(@RequestBody BookingDTO bookingDTO) {
        purchaseBookingDriverService.updatePurchaseBooking(bookingDTO);
        return new ResponceUtil(200, "Updated booking..", null);
    }

    @DeleteMapping(params = {"oid"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil deletePurchaseBookingDriver(@RequestParam String bid) {
        purchaseBookingDriverService.deletePurchaseBooking(bid);
        return new ResponceUtil(200, "Deleted booking...", null);
    }
}
