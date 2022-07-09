package lk.ijse.experdia_car_rental_system.controller;

import lk.ijse.experdia_car_rental_system.dto.AdminDTO;
import lk.ijse.experdia_car_rental_system.service.AdminService;
import lk.ijse.experdia_car_rental_system.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Admin")
@CrossOrigin

public class AdminController {
    @Autowired
    AdminService adminService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil saveAdmin(@ModelAttribute AdminDTO adminDTO){
        adminService.saveAdmin(adminDTO);
        return new ResponceUtil(200,"save",null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil getAllAdmin(){
        return  new ResponceUtil(200,"getAll",adminService.getAllAdmin());
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil deleteAdmin(@RequestParam String id){
        adminService.deleteAdmin(id);
        return new ResponceUtil(200,"deleted",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil updateAdmin(@RequestBody AdminDTO adminDTO){
        adminService.updateAdmin(adminDTO);
        return new ResponceUtil(200,"updated",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil searchAdmin(@PathVariable String id){
        return new ResponceUtil(200,"search",adminService.searchAdmin(id));
    }
}
