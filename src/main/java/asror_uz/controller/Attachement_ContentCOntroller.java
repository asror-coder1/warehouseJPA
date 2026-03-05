package asror_uz.controller;

import asror_uz.dto.Attachement_ContentDto;
import asror_uz.model.Attachement_Content;
import asror_uz.model.Result;
import asror_uz.service.Attachement_ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attachement_content")
@RequiredArgsConstructor

public class Attachement_ContentCOntroller {
    private final Attachement_ContentService service;

    @PostMapping
    public ResponseEntity<Result> add(@RequestBody Attachement_ContentDto dto) {
        Result result = service.create(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attachement_Content> getbyId(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Attachement_Content>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Result> edit(@PathVariable Long id, @RequestBody Attachement_ContentDto dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

}

