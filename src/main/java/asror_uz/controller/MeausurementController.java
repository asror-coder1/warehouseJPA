package asror_uz.controller;

import asror_uz.dto.MeausurementDto;
import asror_uz.model.Meausurement;
import asror_uz.model.Result;
import asror_uz.service.MeausurementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meausurement")
@RequiredArgsConstructor
public class MeausurementController {

    private final MeausurementService meausurementService;

    // ====================== CREATE ======================

    @PostMapping
    public Result create(@RequestBody MeausurementDto dto){
        return meausurementService.create(dto);
    }

    // ====================== READ ALL ======================

    @GetMapping
    public List<Meausurement> getAll(){
        return meausurementService.getAll();
    }

    // ====================== READ BY ID ======================

    @GetMapping("/{id}")
    public Meausurement getById(@PathVariable Long id){
        return meausurementService.getById(id);
    }

    // ====================== UPDATE ======================

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id,
                         @RequestBody MeausurementDto dto){
        return meausurementService.update(id, dto);
    }

    // ====================== DELETE ======================

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        return meausurementService.delete(id);
    }
}