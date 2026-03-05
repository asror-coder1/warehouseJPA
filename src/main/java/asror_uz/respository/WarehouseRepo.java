package asror_uz.respository;

import asror_uz.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepo extends JpaRepository<Warehouse , Long> {
    boolean existsByName(String name);
}
