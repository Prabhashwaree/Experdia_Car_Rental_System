package lk.ijse.experdia_car_rental_system.controller;

import lk.ijse.experdia_car_rental_system.dto.RentalRateDTO;
import lk.ijse.experdia_car_rental_system.service.RentalRateService;
import lk.ijse.experdia_car_rental_system.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("RentalRate")
@CrossOrigin

public class RentalRateController {
    @Autowired
    RentalRateService rentalRateService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil saveRentalRate(@RequestBody RentalRateDTO rentalRateDTO){
        rentalRateService.saveRentalRate(rentalRateDTO);
        return new ResponceUtil(200,"save",null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil getAllRentalRate(){
        return  new ResponceUtil(200,"getAll",rentalRateService.getAllRentalRate());
    }

    @DeleteMapping(params = {"rate_Id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil deleteRentalRate(@RequestParam("rate_Id") String id){
        rentalRateService.deleteRentalRate(id);
        return new ResponceUtil(200,"deleted",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil updateRentalRate(@RequestBody RentalRateDTO rentalRateDTO){
        rentalRateService.updateRentalRate(rentalRateDTO);
        return new ResponceUtil(200,"updated",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil searchRentalRate(@PathVariable String id){
        return new ResponceUtil(200,"search",rentalRateService.searchRentalRate(id));
    }
}
