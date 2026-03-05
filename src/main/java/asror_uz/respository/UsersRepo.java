package asror_uz.respository;

import asror_uz.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users , Long > {
    boolean existsByPhonenumber(String phonenumber);
}
