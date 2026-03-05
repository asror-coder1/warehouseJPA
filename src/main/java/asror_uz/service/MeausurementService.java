package asror_uz.service;

import asror_uz.dto.MeausurementDto;
import asror_uz.model.Meausurement;
import asror_uz.model.Result;
import asror_uz.respository.MeausurementRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MeausurementService {

    private final MeausurementRepo meausurementRepo;

    // ====================== CREATE =====================

    public Result create(MeausurementDto dto){
        Meausurement meausurement = mapEntity(new Meausurement(), dto);
        meausurementRepo.save(meausurement);
        return new Result("Saqlandi", true);
    }

    // ====================== READ ALL =====================

    @Transactional(readOnly = true)
    public List<Meausurement> getAll(){
        return meausurementRepo.findAll();
    }

    // ====================== READ BY ID =====================

    @Transactional(readOnly = true)
    public Meausurement getById(Long id){
        return meausurementRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Meausurement topilmadi ID: " + id));
    }

    // ====================== UPDATE =====================

    public Result update(Long id, MeausurementDto dto){
        Meausurement meausurement = getById(id);
        mapEntity(meausurement, dto);
        meausurementRepo.save(meausurement);
        return new Result("Yangilandi", true);
    }

    // ====================== DELETE =====================

    public Result delete(Long id){
        Meausurement meausurement = getById(id);
        meausurementRepo.delete(meausurement);
        return new Result("O'chirildi", true);
    }

    // ====================== MAPPER =====================

    private Meausurement mapEntity(Meausurement meausurement , MeausurementDto dto){
        meausurement.setName(dto.getName());
        meausurement.setActive(dto.getActive());
        return meausurement;
    }
}