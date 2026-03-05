package asror_uz.controller;

import asror_uz.dto.CurrencyDto;
import asror_uz.model.Currency;
import asror_uz.model.Result;
import asror_uz.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/currency")
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService currencyService;

    @PostMapping
    private ResponseEntity<Result> add(@RequestBody CurrencyDto currencyDto){
        Result result = currencyService.create(currencyDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Currency> getById(@PathVariable Long id){
        return ResponseEntity.ok(currencyService.getbyId(id));
    }

    @GetMapping
    public ResponseEntity<List<Currency>> getAll(){
        return ResponseEntity.ok(currencyService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Result> edit(@PathVariable Long id , @RequestBody CurrencyDto currencyDto){
        return ResponseEntity.ok(currencyService.update(id, currencyDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable Long id){
        return ResponseEntity.ok(currencyService.delete(id));

    }
}
