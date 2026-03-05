package asror_uz.service;

import asror_uz.dto.ProductDto;
import asror_uz.model.Product;
import asror_uz.model.Result;
import asror_uz.respository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    //    ====================== CREATE =====================

    public Result create(ProductDto dto){
        Product product = mapEntity(new Product(), dto);
        productRepo.save(product);

        return new Result("Saqlandi" , true);
    }

    //    ====================== READ BYID =====================

    @Transactional(readOnly = true)
    public Product getById(Long id){
        return productRepo.findById(id).orElseThrow(()-> new RuntimeException("Id topilmadi" + id));
    }

    @Transactional(readOnly = true)
    public List<Product> getAll(){
        return productRepo.findAll();
    }

    //    ====================== UPDATE =====================

    public Result update(Long id , ProductDto dto){
        Product product = getById(id);
        mapEntity(product , dto);
        productRepo.save(product);

        return new Result("Update bo'ldi" , true);
    }

    //    ====================== DELETE =====================

    public Result delete(Long id){
        Product product = getById(id);
        productRepo.delete(product);

        return new Result("Delete bo'ldi" , true);
    }

    //    ====================== MAPPER =====================

    private Product mapEntity(Product product, ProductDto dto) {
        product.setName(dto.getName());
        product.setCategory_id(dto.getCategory_id());
        product.setPhoto_id(dto.getPhoto_id());
        product.setCode(dto.getCode());
        product.setMeasurement_id(dto.getMeasurement_id());
        product.setActive(dto.getActive());
        return product;
    }
}
