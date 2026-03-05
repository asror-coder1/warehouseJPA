package asror_uz.service;

import asror_uz.dto.CurrencyDto;
import asror_uz.model.Currency;
import asror_uz.model.Result;
import asror_uz.respository.CurrencyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CurrencyService {

    @Autowired
    CurrencyRepo currencyRepo;

    //    ====================== CREATE =====================

    public Result create(CurrencyDto currencyDto){

        Currency currency = mapEntity(new Currency(), currencyDto);
        currencyRepo.save(currency);

        return new Result("Saqlandi" , true);
    }

    //    ====================== READ GEtbyId and ALL =====================

    @Transactional(readOnly = true)
    public Currency getbyId(Long id){
        return currencyRepo.findById(id).orElseThrow(() -> new RuntimeException("Currency topilmadi" + id));
    }

    @Transactional(readOnly = true)
    public List<Currency> getAll(){
        return currencyRepo.findAll();
    }

    //    ====================== UPDATE =====================

    public Result update(Long id , CurrencyDto currencyDto){
        Currency currency = getbyId(id);

        mapEntity(currency , currencyDto);
        currencyRepo.save(currency);

        return new Result("Update bo'ldi" , true);
    }

    //    ====================== DELETE =====================

    public Result delete(Long id){
        Currency currency = getbyId(id);
        currencyRepo.save(currency);

        return new Result("O'chirildi" , true);
    }


    //    ====================== MAPPER =====================

    private Currency mapEntity(Currency currency , CurrencyDto currencyDto){
        currency.setName(currencyDto.getName());
        currency.setActive(currencyDto.getActive());
        return currency;
    }
}
