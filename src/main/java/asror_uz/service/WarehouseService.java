package asror_uz.service;

import asror_uz.dto.WarehouseDto;
import asror_uz.model.Result;
import asror_uz.model.Warehouse;
import asror_uz.respository.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.smartcardio.Card;
import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {

    @Autowired
    WarehouseRepo warehouseRepo;

//    CRUD

//    Create
    public Result create (WarehouseDto warehouseDto){
        Warehouse warehouse = new Warehouse();
        warehouse.setName(warehouseDto.getName());
        warehouse.setActive(warehouseDto.getActive());

        warehouseRepo.save(warehouse);
        return new Result("Saqlandi" ,true);
    }

//    Read id

    public Warehouse getbyId(Long id){
        Optional<Warehouse> warehouseOptional = warehouseRepo.findById(id);
        return warehouseOptional.get();
    }

//    Read all

    public List<Warehouse> getall(){
        List<Warehouse> warehouseList = warehouseRepo.findAll();
        return warehouseList;
    }

//    Update

    public Result update(Long id , WarehouseDto warehouseDto){
        Optional<Warehouse> optional = warehouseRepo.findById(id);
        if (optional.isPresent()){
            Warehouse warehouse = optional.get();
            warehouse.setName(warehouseDto.getName());
            warehouse.setActive(warehouseDto.getActive());

            warehouseRepo.save(warehouse);
            return  new Result("O'zgartirildi" , true);
        }
        return new Result("Id topilmadi" , false);
    }

    public Result delete(Long id){
       warehouseRepo.deleteById(id);
       return new Result("deleted" , true);
    }
}
