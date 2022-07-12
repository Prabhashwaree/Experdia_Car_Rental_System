package lk.ijse.experdia_car_rental_system.controller;


import lk.ijse.experdia_car_rental_system.dto.CustomerDTO;
import lk.ijse.experdia_car_rental_system.service.CustomerService;
import lk.ijse.experdia_car_rental_system.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Customer")
@CrossOrigin

public class CustomerController {
    @Autowired
    CustomerService customerService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil saveCustomer(@RequestBody CustomerDTO customerDTO){
        System.out.println(customerDTO.toString());
        customerService.saveCustomer(customerDTO);
        return new ResponceUtil(200,"save",null);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil getAllCustomer(){
        return  new ResponceUtil(200,"getAll",customerService.getAllCustomer());
    }

    @DeleteMapping(params = {"nIC_No"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil deleteCustomer(@RequestParam("nIC_No") String id){
        customerService.deleteCustomer(id);
        return new ResponceUtil(200,"deleted",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil updateCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(customerDTO);
        return new ResponceUtil(200,"updated",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil searchCustomer(@PathVariable String id){
        return new ResponceUtil(200,"search",customerService.searchCustomer(id));
    }
}
