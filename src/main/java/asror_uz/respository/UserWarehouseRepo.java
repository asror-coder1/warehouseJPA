package asror_uz.respository;

import asror_uz.model.UserWarehouse;
import asror_uz.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWarehouseRepo extends JpaRepository<UserWarehouse, Long > {
}
