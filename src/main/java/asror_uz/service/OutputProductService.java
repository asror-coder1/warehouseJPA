package asror_uz.service;

import asror_uz.dto.OutputProductDto;
import asror_uz.model.OutputProduct;
import asror_uz.model.Result;
import asror_uz.respository.OutputProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OutputProductService {

    @Autowired
    OutputProductRepo outputProductRepo;

//    ================ CRUD ======================

//    ================ CREATE ======================

    public Result create(OutputProductDto outputProductDto){
        OutputProduct outputProduct = mapEntity(new OutputProduct(), outputProductDto);
        outputProductRepo.save(outputProduct);

        return new Result("Saqlandi" , true);
    }

//    ================ READ BYID ======================

    @Transactional(readOnly = true)
    public OutputProduct getbyid (Long id){
        return outputProductRepo.findById(id).orElseThrow(() -> new RuntimeException("OutputProduct topilmadi" + id));
    }

//    ================ READ ALL ======================

    @Transactional(readOnly = true)
    public List<OutputProduct> getAll(){
        return outputProductRepo.findAll();
    }

//    ================ UPDATE ======================

    public Result update(Long id , OutputProductDto dto){
        OutputProduct outputProduct = getbyid(id);

        mapEntity(outputProduct , dto);
        outputProductRepo.save(outputProduct);

        return new Result("Update bo'ldi" , true);
    }

//    ================ DELETE ======================

    public Result delete (Long id){
        OutputProduct outputProduct = getbyid(id);
        outputProductRepo.save(outputProduct);

        return new Result("Deleted" , true);
    }


//    ========================= MAPPER ===================
    private OutputProduct mapEntity(OutputProduct outputProduct , OutputProductDto outputProductDto){
        outputProduct.setProduct_id(outputProductDto.getProduct_id());
        outputProduct.setAmount(outputProductDto.getAmount());
        outputProduct.setPrice(outputProductDto.getPrice());
        outputProduct.setOutput_id(outputProductDto.getOutput_id());
        return outputProduct;
    }
}
