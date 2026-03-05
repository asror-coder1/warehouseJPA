package asror_uz.service;

import asror_uz.dto.InputDto;
import asror_uz.model.Input;
import asror_uz.model.Result;
import asror_uz.respository.InputRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InputService {
    @Autowired
    InputRepo inputRepo;

//    ====================== CREATE =====================

    public Result create(InputDto inputDto){
        Input input = mapEntity(new Input(), inputDto);
        inputRepo.save(input);

        return new Result("Saqlandi" , true);
    }

//    ====================== READ ID =====================

    @Transactional(readOnly = true)
    public Input getById(Long id){
        return inputRepo.findById(id).orElseThrow(() -> new RuntimeException("Input topilmadi" + id));
    }

//    ====================== READ ALL =====================

    @Transactional(readOnly = true)
    public List<Input> getAll(){
        return inputRepo.findAll();
    }

//    ====================== UPDATE =====================

    public Result update (Long id , InputDto inputDto){
        Input input = getById(id);

        mapEntity(input , inputDto);
        inputRepo.save(input);

        return new Result("Update bo'ldi" , true);
    }

//    ====================== DELETE =====================

    public Result delete(Long id){
        Input input = getById(id);
        inputRepo.delete(input);

        return new Result("Muvaffaqiyatli o'chirildi" , true);
    }


//    ====================== MAPPER =====================

    private Input mapEntity(Input input , InputDto inputDto){
        input.setDate(inputDto.getDate());
        input.setWarehouse_id(inputDto.getWarehouse_id());
        input.setSupplier_id(inputDto.getSupplier_id());
        input.setCurrency_id(inputDto.getCurrency_id());
        input.setFacture_number(inputDto.getFacture_number());
        input.setCode(inputDto.getCode());
        return input;
    }
}
