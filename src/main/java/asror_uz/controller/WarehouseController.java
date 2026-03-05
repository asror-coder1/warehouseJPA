package asror_uz.controller;

import asror_uz.dto.WarehouseDto;
import asror_uz.model.Result;
import asror_uz.model.Warehouse;
import asror_uz.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouse")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

//    Create

    @PostMapping
    public Result add(@RequestBody WarehouseDto warehouseDto){
        Result result = warehouseService.create(warehouseDto);
        return result;
    }

//    id

    @GetMapping("/{id}")
    public Warehouse byid(@PathVariable Long id){
        return warehouseService.getbyId(id);
    }

//    all

    @GetMapping
    public List<Warehouse> all(){
        return warehouseService.getall();
    }

//    Update

    @PutMapping("/{id}")
    public Result edit(@PathVariable Long id , @RequestBody WarehouseDto warehouseDto){
        Result upadte = warehouseService.update(id, warehouseDto);
        return upadte;
    }

//    Deleted

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable Long id){
        Result result = warehouseService.delete(id);
        return ResponseEntity
                .status(result.isSuccess() ? 200 : 404)
                .body(result);
    }

}
