package asror_uz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Input {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private Long warehouse_id;
    private Long supplier_id;
    private Long currency_id;
    @Column(nullable = false , unique = true)
    private String facture_number;
    private String code;
    private LocalDateTime dateTime = LocalDateTime.now();
}
