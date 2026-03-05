package asror_uz.service;

import asror_uz.dto.OutputDto;
import asror_uz.model.Output;
import asror_uz.model.Result;
import asror_uz.respository.OutputRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OutputService {

    private final OutputRepo outputRepo;

    /* ================= CREATE ================= */

    public Result create(OutputDto dto) {

        Output output = mapToEntity(new Output(), dto);
        outputRepo.save(output);

        return new Result("Muvaffaqiyatli saqlandi", true);
    }

    /* ================= READ ================= */

    @Transactional(readOnly = true)
    public Output getById(Long id) {
        return outputRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Output topilmadi ID: " + id));
    }

    @Transactional(readOnly = true)
    public List<Output> getAll() {
        return outputRepo.findAll();
    }

    /* ================= UPDATE ================= */

    public Result update(Long id, OutputDto dto) {

        Output output = getById(id);

        mapToEntity(output, dto);
        outputRepo.save(output);

        return new Result("Update bo‘ldi", true);
    }

    /* ================= DELETE ================= */

    public Result delete(Long id) {

        Output output = getById(id);
        outputRepo.delete(output);

        return new Result("Muvaffaqiyatli delete bo‘ldi", true);
    }

    /* ================= MAPPER ================= */

    private Output mapToEntity(Output output, OutputDto dto) {
        output.setDate(dto.getDate());
        output.setWarehouse_id(dto.getWarehouse_id());
        output.setCurrency_id(dto.getCurrency_id());
        output.setFacture_number(dto.getFacture_number());
        output.setCode(dto.getCode());
        output.setClient_id(dto.getClient_id());
        return output;
    }
}