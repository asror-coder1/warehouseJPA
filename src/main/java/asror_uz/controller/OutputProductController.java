package asror_uz.controller;

import asror_uz.dto.OutputProductDto;
import asror_uz.model.OutputProduct;
import asror_uz.model.Result;
import asror_uz.service.OutputProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/output_product")
@RequiredArgsConstructor
public class OutputProductController {

    private final OutputProductService outputProductService;

    @PostMapping
    public ResponseEntity<Result> add(@RequestBody OutputProductDto outputProductDto){
        Result result = outputProductService.create(outputProductDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")

    public ResponseEntity<OutputProduct> getById(@PathVariable Long id){
        return ResponseEntity.ok(outputProductService.getbyid(id));
    }

    @GetMapping
    public ResponseEntity<List<OutputProduct>> getAll() {
        return ResponseEntity.ok(outputProductService.getAll());
    }

    @PutMapping("/{id}")

    public ResponseEntity<Result> edit(@PathVariable Long id , @RequestBody OutputProductDto outputProductDto){
        return ResponseEntity.ok(outputProductService.update(id, outputProductDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable Long id){
        return ResponseEntity.ok(outputProductService.delete(id));
    }

}