package asror_uz.service;

import asror_uz.dto.CategoryDto;
import asror_uz.model.Category;
import asror_uz.model.Result;
import asror_uz.respository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepo categoryRepo;

    // ====================== CREATE =====================

    public Result create(CategoryDto dto){
        Category category = mapEntity(new Category(), dto);
        categoryRepo.save(category);
        return new Result("Saqlandi", true);
    }

    // ====================== READ ALL =====================

    @Transactional(readOnly = true)
    public List<Category> getAll(){
        return categoryRepo.findAll();
    }

    // ====================== READ BY ID =====================

    @Transactional(readOnly = true)
    public Category getById(Long id){
        return categoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category topilmadi ID: " + id));
    }

    // ====================== UPDATE =====================

    public Result update(Long id, CategoryDto dto){
        Category category = getById(id);

        mapEntity(category, dto);
        categoryRepo.save(category);

        return new Result("Yangilandi", true);
    }

    // ====================== DELETE =====================

    public Result delete(Long id){
        Category category = getById(id);

        categoryRepo.delete(category);

        return new Result("O'chirildi", true);
    }

    // ====================== MAPPER =====================

    private Category mapEntity(Category category , CategoryDto dto){
        category.setName(dto.getName());
        category.setParentCategoryId(dto.getParentCategoryId());
        category.setActive(dto.getActive());
        return category;
    }
}