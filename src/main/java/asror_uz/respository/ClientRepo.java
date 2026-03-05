package asror_uz.respository;

import asror_uz.model.Cleint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Cleint , Long> {
}
