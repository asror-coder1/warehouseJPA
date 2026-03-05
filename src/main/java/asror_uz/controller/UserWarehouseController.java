package asror_uz.controller;

import asror_uz.dto.UserWarehouseDto;
import asror_uz.model.Result;
import asror_uz.model.UserWarehouse;
import asror_uz.service.UserWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user_warehouse")
public class UserWarehouseController {

    @Autowired
    UserWarehouseService userWarehouseService;

//    Create
    @PostMapping
    public Result add (@RequestBody UserWarehouseDto userWarehouseDto){
        return  userWarehouseService.create(userWarehouseDto);
    }

//    Read by id
    @GetMapping("/{id}")
    public UserWarehouse byid(@PathVariable Long id){
        return userWarehouseService.getbyid(id);
    }

//    Read all
    @GetMapping
    public List<UserWarehouse> all(){
        List<UserWarehouse> getall = userWarehouseService.getall();
        return getall;
    }

//    Update

    @PutMapping("/{id}")
    public Result edit(@PathVariable Long id , @RequestBody UserWarehouseDto userWarehouseDto){
        Result update = userWarehouseService.update(id, userWarehouseDto);
        return update;
    }

//    Deleted

    @DeleteMapping("/{id}")

    public Result delete(@PathVariable Long id){
        Result deleted = userWarehouseService.deleted(id);
        return deleted;
    }

}
