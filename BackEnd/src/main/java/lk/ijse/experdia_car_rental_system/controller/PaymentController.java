package lk.ijse.experdia_car_rental_system.controller;

import lk.ijse.experdia_car_rental_system.dto.PaymentDTO;
import lk.ijse.experdia_car_rental_system.service.PaymentService;
import lk.ijse.experdia_car_rental_system.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Payment")
@CrossOrigin

public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil savePayment(@RequestBody PaymentDTO paymentDTO){
        paymentService.savePayment(paymentDTO);
        return new ResponceUtil(200,"save",null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil getAllPayment(){
        return  new ResponceUtil(200,"getAll",paymentService.getAllPayment());
    }

    @DeleteMapping(params = {"payment_Id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil deletePayment(@RequestParam("payment_Id") String id){
        paymentService.deletePayment(id);
        return new ResponceUtil(200,"deleted",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil updatePayment(@RequestBody PaymentDTO paymentDTO){
        paymentService.updatePayment(paymentDTO);
        return new ResponceUtil(200,"updated",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil searchPayment(@PathVariable String id){
        return new ResponceUtil(200,"search",paymentService.searchPayment(id));
    }
}
