package asror_uz.controller;

import asror_uz.dto.SupplierDto;
import asror_uz.model.Result;
import asror_uz.model.Supplier;
import asror_uz.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @PostMapping
    public ResponseEntity<Result> add(@RequestBody SupplierDto supplierDto){
        Result result = supplierService.create(supplierDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getbyid(@PathVariable Long id){
        return ResponseEntity.ok(supplierService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getALl(){
        return ResponseEntity.ok(supplierService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Result> edit(@PathVariable Long id , @RequestBody SupplierDto supplierDto){
        return ResponseEntity.ok(supplierService.update(id, supplierDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete (@PathVariable Long id){
        return ResponseEntity.ok(supplierService.delete(id));
    }

}
