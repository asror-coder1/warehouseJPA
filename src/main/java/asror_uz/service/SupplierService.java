package asror_uz.service;

import asror_uz.dto.SupplierDto;
import asror_uz.model.Result;
import asror_uz.model.Supplier;
import asror_uz.respository.SupplierRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SupplierService {

    @Autowired
    SupplierRepo supplierRepo;

//    CRUD

//    ============== CREATE =================

    public Result create(SupplierDto supplierDto){
        Supplier supplier = mapEntity(new Supplier(), supplierDto);
        supplierRepo.save(supplier);

        return new Result("Saqlandi" , true);
    }

//    ============== READ ByID =================

    @Transactional(readOnly = true)
    public Supplier getById(Long id){
        return supplierRepo.findById(id).orElseThrow(() -> new RuntimeException("Supplier topilmadi" + id));
    }

    @Transactional(readOnly = true)
    public List<Supplier> getAll(){
        return supplierRepo.findAll();
    }

//    ============== UPDATE =================

    public Result update(Long id , SupplierDto supplierDto){
        Supplier supplier = getById(id);
        mapEntity(supplier , supplierDto);
        supplierRepo.save(supplier);

        return new Result("Update bo'di" , true);
    }

//    ============== DELETE =================

    public Result delete(Long id){
        Supplier supplier = getById(id);
        supplierRepo.delete(supplier);

        return new Result("O'chirildi" , true);
    }



//    ============== MAPPER =================

    private Supplier mapEntity(Supplier supplier , SupplierDto supplierDto){
        supplier.setName(supplierDto.getName());
        supplier.setActive(supplierDto.getActive());
        supplier.setPhone_number(supplierDto.getPhone_number());
        return supplier;
    }
}
