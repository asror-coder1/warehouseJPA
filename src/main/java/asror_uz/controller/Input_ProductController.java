package asror_uz.controller;

import asror_uz.dto.Input_ProductDto;
import asror_uz.model.Input_Product;
import asror_uz.model.Result;
import asror_uz.service.Input_ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/input_product")
@RequiredArgsConstructor
public class Input_ProductController {

    private final Input_ProductService productService;

    // ====================== CREATE ======================
    @PostMapping
    public Result create(@RequestBody Input_ProductDto dto) {
        return productService.create(dto);
    }

    // ====================== READ ALL ======================
    @GetMapping
    public List<Input_Product> getAll() {
        return productService.getAll();
    }

    // ====================== READ BY ID ======================
    @GetMapping("/{id}")
    public Input_Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    // ====================== UPDATE ======================
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id,
                         @RequestBody Input_ProductDto dto) {
        return productService.update(id, dto);
    }

    // ====================== DELETE ======================
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return productService.delete(id);
    }
}