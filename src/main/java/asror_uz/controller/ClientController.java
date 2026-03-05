package asror_uz.controller;

import asror_uz.dto.ClientDto;
import asror_uz.model.Cleint;
import asror_uz.model.Result;
import asror_uz.service.CleintService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.TypeCollector;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {
    private final CleintService cleintService;

    @PostMapping
    public ResponseEntity<Result> add(@RequestBody ClientDto clientDto){
        Result result = cleintService.create(clientDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cleint> getbyid(@PathVariable Long id){
        return ResponseEntity.ok(cleintService.getbyId(id));
    }

    @GetMapping
    public ResponseEntity<List<Cleint>> getAll(){
        return ResponseEntity.ok(cleintService.getALl());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Result> edit(@PathVariable Long id , @RequestBody ClientDto clientDto){
        return ResponseEntity.ok(cleintService.update(id, clientDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable Long id){
        return ResponseEntity.ok(cleintService.delete(id));
    }
}
