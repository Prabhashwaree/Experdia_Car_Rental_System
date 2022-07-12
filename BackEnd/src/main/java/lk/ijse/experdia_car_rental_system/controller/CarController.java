package lk.ijse.experdia_car_rental_system.controller;

import lk.ijse.experdia_car_rental_system.dto.CarDTO;
import lk.ijse.experdia_car_rental_system.service.CarService;
import lk.ijse.experdia_car_rental_system.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Car")
@CrossOrigin

public class CarController {
    @Autowired
    CarService carService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil saveCar(@RequestBody CarDTO carDTO){
        carService.saveCar(carDTO);
        return new ResponceUtil(200,"save",null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil getAllCar(){
        return  new ResponceUtil(200,"getAll",carService.getAllCar());
    }

    @DeleteMapping(params = {"register_No"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil deleteCar(@RequestParam("register_No") String id){
        carService.deleteCar(id);
        return new ResponceUtil(200,"deleted",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil updateCar(@RequestBody CarDTO carDTO){
        carService.updateCar(carDTO);
        return new ResponceUtil(200,"updated",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil searchCar(@PathVariable String id){
        return new ResponceUtil(200,"search",carService.searchCar(id));
    }
}
