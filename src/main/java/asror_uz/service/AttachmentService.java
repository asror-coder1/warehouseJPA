package asror_uz.service;

import asror_uz.dto.AttachmentDto;
import asror_uz.model.Attachment;
import asror_uz.model.Result;
import asror_uz.respository.AttachmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.image.RescaleOp;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AttachmentService {
    private final AttachmentRepo attachmentRepo;

//    ============= CREATE ==================

    public Result create (AttachmentDto dto){
        Attachment attachment = mapEntity(new Attachment(), dto);
        attachmentRepo.save(attachment);

        return new Result("Saqlandi" , true);
    }

//    ============= READ ID ==================

    @Transactional(readOnly = true)
    public Attachment getbyId(Long id){
        return attachmentRepo.findById(id).orElseThrow(() -> new RuntimeException("Id Topilmadi" + id));
    }

//    ============= RED ALL ==================

    @Transactional(readOnly = true)
    public List<Attachment> getAll(){
        return attachmentRepo.findAll();
    }

//    ============= UPDATE ==================

    public Result uodate(Long id , AttachmentDto dto){
        Attachment attachment = attachmentRepo.findById(id).orElseThrow(() -> new RuntimeException("ID topilmadi :" + id));

        mapEntity(attachment , dto);

        return new Result("Update boldi" , true);
    }

//    ============= DELETE ==================

    public Result delete(Long id){
        Attachment attachment = attachmentRepo.findById(id).orElseThrow(() -> new RuntimeException("Id topilmadi" + id));

        attachmentRepo.delete(attachment);

        return new Result("Delete boldi" , true);
    }


//    ============= MAPPER ==================

    private Attachment mapEntity(Attachment attachment , AttachmentDto attachmentDto){
        attachment.setName(attachmentDto.getName());
        attachment.setSize(attachmentDto.getSize());
        attachment.setContent_type(attachmentDto.getContent_type());
        return attachment;
    }


}
