package asror_uz.respository;

import asror_uz.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepo extends JpaRepository<Currency , Long> {
}
