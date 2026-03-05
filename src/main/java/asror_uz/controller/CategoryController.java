package asror_uz.controller;

import asror_uz.dto.CategoryDto;
import asror_uz.model.Category;
import asror_uz.model.Result;
import asror_uz.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // ====================== CREATE ======================

    @PostMapping
    public Result create(@RequestBody CategoryDto dto){
        return categoryService.create(dto);
    }

    // ====================== READ ALL ======================

    @GetMapping
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    // ====================== READ BY ID ======================

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id){
        return categoryService.getById(id);
    }

    // ====================== UPDATE ======================

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id,
                         @RequestBody CategoryDto dto){
        return categoryService.update(id, dto);
    }

    // ====================== DELETE ======================

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        return categoryService.delete(id);
    }
}