package asror_uz.service;

import asror_uz.dto.ClientDto;
import asror_uz.model.Cleint;
import asror_uz.model.Result;
import asror_uz.respository.ClientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CleintService {

    private final ClientRepo clientRepo;

//    CRUD

//    ====================== CREATE =====================

    public Result create(ClientDto clientDto) {

        Cleint cleint = mapEntity(new Cleint(), clientDto);
        clientRepo.save(cleint);

        return new Result("Muvaffaqiyatli saqlandi", true);
    }


//    ====================== READ  =====================

    @Transactional(readOnly = true)
    public Cleint getbyId(Long id) {
        return clientRepo.findById(id).orElseThrow(() -> new RuntimeException("Output topilmadi" + id));
    }

    @Transactional(readOnly = true)
    public List<Cleint> getALl() {
        return clientRepo.findAll();
    }

//    ====================== UPDATE =====================

    public Result update(Long id, ClientDto dto) {
        Cleint cleint = getbyId(id);

        mapEntity(cleint, dto);
        clientRepo.save(cleint);

        return new Result("Update bo'ldi", true);
    }

//    ====================== DELETE =====================

    public Result delete(Long id) {
        Cleint client = getbyId(id);
        clientRepo.delete(client);

        return new Result("Muvaffaqiyatli o‘chirildi", true);
    }


//    ====================== MAPPER =====================

    private Cleint mapEntity(Cleint cleint, ClientDto clientDto) {
        cleint.setName(clientDto.getName());
        cleint.setPhone_number(clientDto.getPhone_number());
        return cleint;
    }

}
