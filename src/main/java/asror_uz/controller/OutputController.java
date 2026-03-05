package asror_uz.controller;

import asror_uz.dto.OutputDto;
import asror_uz.model.Output;
import asror_uz.model.Result;
import asror_uz.service.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/output")
public class OutputController {

    @Autowired
    OutputService outputService;

    @PostMapping
    public Result add (@RequestBody OutputDto outputDto){
        Result result = outputService.create(outputDto);
        return result;
    }

    @GetMapping("/{id}")

    public Output byid(@PathVariable Long id){
        return outputService.getById(id);
    }

    @GetMapping
    public List<Output> all(){
        return outputService.getAll();
    }

    @PutMapping("/{id}")

    public Result edit(@PathVariable Long id , @RequestBody OutputDto outputDto){
        Result update = outputService.update(id, outputDto);
        return update;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        Result delete = outputService.delete(id);
        return delete;
    }
}
