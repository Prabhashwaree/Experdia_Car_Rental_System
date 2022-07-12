package lk.ijse.experdia_car_rental_system.controller;

import lk.ijse.experdia_car_rental_system.dto.UserLoginDTO;
import lk.ijse.experdia_car_rental_system.service.UserLoginService;
import lk.ijse.experdia_car_rental_system.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("UserLogin")
@CrossOrigin

public class UserLoginController {
    @Autowired
    UserLoginService userLoginService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil saveUserLogin(@RequestBody UserLoginDTO userLoginDTO){//@ModelAttribute danna ona
        userLoginService.saveUserLogin(userLoginDTO);
        return new ResponceUtil(200,"save",HttpStatus.CREATED);


    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil getAllUserLogin(){
        return  new ResponceUtil(200,"getAll",userLoginService.getAllUserLogin());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"user_Id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil deleteUserLogin(@RequestParam("user_Id") String id){
        userLoginService.deleteUserLogin(id);
        return new ResponceUtil(200,"deleted",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil updateUserLogin(@RequestBody UserLoginDTO userLoginDTO){
        userLoginService.updateUserLogin(userLoginDTO);
        return new ResponceUtil(200,"updated",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil searchUserLogin(@PathVariable String id){
        return new ResponceUtil(200,"search",userLoginService.searchUserLogin(id));
    }
}
