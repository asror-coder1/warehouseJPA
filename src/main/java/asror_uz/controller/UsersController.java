package asror_uz.controller;

import asror_uz.dto.UsersDto;
import asror_uz.model.Result;
import asror_uz.model.Users;
import asror_uz.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UsersController {
    @Autowired
    UsersService usersService;

    @PostMapping
    public Result add(@RequestBody UsersDto usersDto){
        return usersService.create(usersDto);
    }

//    Id boyicha

    @GetMapping("/{id}")
    public Users byid(@PathVariable Long id){
        Users getbyid = usersService.getbyid(id);
        return getbyid;
    }

//    all hamamsini 0lish

    @GetMapping
    public List<Users> all(){
        return usersService.getall();
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Long id , @RequestBody UsersDto usersDto){
        Result update = usersService.update(id, usersDto);
        return update;
    }

    @DeleteMapping("/{id}")

    public Result delete(@PathVariable Long id){
        Result delete = usersService.delete(id);
        return delete;
    }
}
