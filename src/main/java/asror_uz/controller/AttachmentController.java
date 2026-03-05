package asror_uz.controller;

import asror_uz.dto.AttachmentDto;
import asror_uz.model.Attachment;
import asror_uz.model.Result;
import asror_uz.service.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attachement")
@RequiredArgsConstructor
public class AttachmentController {
   private final AttachmentService service;

   @PostMapping
    public ResponseEntity<Result> add (@RequestBody AttachmentDto attachmentDto){
       Result result = service.create(attachmentDto);
       return ResponseEntity.ok(result);
   }

   @GetMapping("/{id}")
    public ResponseEntity<Attachment> getById(@PathVariable Long id){
       Attachment attachment = service.getbyId(id);
       return ResponseEntity.ok(attachment);
   }

   @GetMapping
    public ResponseEntity<List<Attachment>> getAll(){
       return ResponseEntity.ok(service.getAll());
   }

   @PutMapping("/{id}")

    public ResponseEntity<Result> edit (@PathVariable Long id , @RequestBody AttachmentDto dto){
       return ResponseEntity.ok(service.uodate(id, dto));
   }

   @DeleteMapping("/{id}")

   public ResponseEntity<Result> delete (@PathVariable Long id){
       return ResponseEntity.ok(service.delete(id));
   }

}
