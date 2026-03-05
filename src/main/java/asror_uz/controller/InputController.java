package asror_uz.controller;

import asror_uz.dto.InputDto;
import asror_uz.model.Input;
import asror_uz.model.Result;
import asror_uz.service.InputService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/input")
@RequiredArgsConstructor
public class InputController {
    private final InputService inputService;

    @PostMapping
    public ResponseEntity<Result> add(@RequestBody InputDto inputDto){
        Result result = inputService.create(inputDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Input> byId(@PathVariable Long id){
        Input byId = inputService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @GetMapping
    public ResponseEntity<List<Input>> all(){
        return ResponseEntity.ok(inputService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Result> edit(@PathVariable Long id , @RequestBody InputDto inputDto){
        return ResponseEntity.ok(inputService.update(id, inputDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable Long id){
        return ResponseEntity.ok(inputService.delete(id));
    }
}
