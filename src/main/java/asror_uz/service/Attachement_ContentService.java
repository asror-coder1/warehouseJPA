package asror_uz.service;

import asror_uz.dto.Attachement_ContentDto;
import asror_uz.model.Attachement_Content;
import asror_uz.model.Result;
import asror_uz.respository.Attachement_ContentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class Attachement_ContentService {

    private final Attachement_ContentRepo attachementContentRepo;

    // ====================== CREATE =====================

    public Result create(Attachement_ContentDto dto){
        Attachement_Content entity = mapEntity(new Attachement_Content(), dto);
        attachementContentRepo.save(entity);
        return new Result("Saqlandi ", true);
    }

    // ====================== UPDATE =====================

    public Result update(Long id, Attachement_ContentDto dto){
        Attachement_Content entity = attachementContentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Topilmadi ID: " + id));

        mapEntity(entity, dto);
        attachementContentRepo.save(entity);

        return new Result("Yangilandi", true);
    }

    // ====================== DELETE =====================

    public Result delete(Long id){
        Attachement_Content entity = attachementContentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Topilmadi ID: " + id));

        attachementContentRepo.delete(entity);

        return new Result("O‘chirildi", true);
    }

    // ====================== GET BY ID =====================

    @Transactional(readOnly = true)
    public Attachement_Content getById(Long id){
        return attachementContentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Topilmadi ID: " + id));
    }

    @Transactional(readOnly = true)
    public List<Attachement_Content> getAll(){
        return attachementContentRepo.findAll();
    }

    // ====================== MAPPER =====================

    private Attachement_Content mapEntity(Attachement_Content entity, Attachement_ContentDto dto){
        entity.setBytee(dto.getBytee());
        entity.setAttachement_id(dto.getAttachement_id());
        return entity;
    }
}