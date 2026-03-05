package asror_uz.service;

import asror_uz.dto.UserWarehouseDto;
import asror_uz.model.Result;
import asror_uz.model.UserWarehouse;
import asror_uz.respository.UserWarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserWarehouseService {
    @Autowired
    UserWarehouseRepo userWarehouseRepo;

//    Crud
public Result create(UserWarehouseDto userWarehouseDto){

    UserWarehouse userWarehouse = new UserWarehouse();

    userWarehouse.setUser_id(userWarehouseDto.getUser_id());
    userWarehouse.setWarehouse_id(userWarehouseDto.getWarehouse_id());

    userWarehouseRepo.save(userWarehouse);

    return new Result("Saqlandi", true);
}

//    Read idsi boyicha olish


    public UserWarehouse getbyid(Long id){
        Optional<UserWarehouse> byId = userWarehouseRepo.findById(id);
        return byId.orElse(null);
    }

//    read hammasini olish yani all

    public List<UserWarehouse> getall(){
        return userWarehouseRepo.findAll();
    }

//    Update

    public Result update(Long id , UserWarehouseDto userWarehouseDto){
        Optional<UserWarehouse> optional = userWarehouseRepo.findById(id);
        if (optional.isPresent()){
            UserWarehouse userWarehouse = optional.get();
            userWarehouse.setUser_id(userWarehouseDto.getUser_id());
            userWarehouse.setWarehouse_id(userWarehouseDto.getWarehouse_id());

            userWarehouseRepo.save(userWarehouse);
            return new Result("Update boldi" , true);
        }
        return  new Result("Id topilmadi" , false);
    }

//    Delete

    public Result deleted(Long id){
        if(userWarehouseRepo.existsById(id)){
            userWarehouseRepo.deleteById(id);
            return new Result("Muvaffaqiyatli delete boldi", true);
        }
        return new Result("Id topilmadi", false);
    }



}
