package asror_uz.service;

import asror_uz.dto.UsersDto;
import asror_uz.model.Result;
import asror_uz.model.Users;
import asror_uz.respository.UsersRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    UsersRepo usersRepo;

//    CRUD;

//    Create

    public Result create (UsersDto usersDto){

        boolean existsByPhonenumber = usersRepo.existsByPhonenumber(usersDto.getPhonenumber());
        if (existsByPhonenumber){
            return new Result("Bunday phone num ber topilmadi" , false);
        }
        Users users = new Users();
        users.setFirstname(usersDto.getFirstname());
        users.setLastname(usersDto.getLastname());
        users.setPhonenumber(usersDto.getPhonenumber());
        users.setCode(usersDto.getCode());
        users.setPassword(usersDto.getPassword());

        usersRepo.save(users);
        return new Result("Saqlandi" , true);
    }

//    Read byid

    public Users getbyid(Long id){
        Optional<Users> optional = usersRepo.findById(id);
        return optional.orElse(null);
    }

//    all

    public List<Users> getall(){
        return usersRepo.findAll();
    }

//    Update

    public  Result update(Long id , UsersDto usersDto){
        Optional<Users> optional = usersRepo.findById(id);
        if (optional.isPresent()){
            Users users = optional.get();
            users.setFirstname(usersDto.getFirstname());
            users.setLastname(usersDto.getLastname());
            users.setPhonenumber(users.getPhonenumber());
            users.setCode(usersDto.getCode());
            users.setPassword(users.getPassword());

            usersRepo.save(users);
            return new Result("Update boldi" , true);
        }
        return new Result("Id topilmadi" , false);
    }

    public Result delete(Long id){
        usersRepo.deleteById(id);
        return  new Result("Delete boldi" , true);
    }

}
