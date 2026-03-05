package asror_uz.service;

import asror_uz.dto.Input_ProductDto;
import asror_uz.model.Input_Product;
import asror_uz.model.Result;
import asror_uz.respository.Input_ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class Input_ProductService {

    private final Input_ProductRepo productRepo;

    // ====================== CREATE ======================
    public Result create(Input_ProductDto dto) {

        Input_Product product = new Input_Product();
        mapEntity(product, dto);

        productRepo.save(product);

        return new Result("Input Product muvaffaqiyatli saqlandi", true);
    }


    // ====================== READ ALL ======================
    @Transactional(readOnly = true)
    public List<Input_Product> getAll() {
        return productRepo.findAll();
    }


    // ====================== READ BY ID ======================
    @Transactional(readOnly = true)
    public Input_Product getById(Long id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Input Product topilmadi  ID: " + id));
    }


    // ====================== UPDATE ======================
    public Result update(Long id, Input_ProductDto dto) {

        Input_Product product = getById(id);

        mapEntity(product, dto);

        productRepo.save(product);

        return new Result("Input Product yangilandi", true);
    }


    // ====================== DELETE ======================
    public Result delete(Long id) {

        Input_Product product = getById(id);

        productRepo.delete(product);

        return new Result("Input Product o‘chirildi", true);
    }


    // ====================== MAPPER ======================
    private Input_Product mapEntity(Input_Product product, Input_ProductDto dto) {
        product.setProduct_id(dto.getProduct_id());
        product.setAmount(dto.getAmount());
        product.setPrice(dto.getPrice());
        product.setExpire_date(dto.getExpire_date());
        product.setInput_id(dto.getInput_id());
        return product;
    }
}