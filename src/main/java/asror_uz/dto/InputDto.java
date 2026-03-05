package asror_uz.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputDto {
    private String date;
    private Long warehouse_id;
    private Long supplier_id;
    private Long currency_id;
    private String facture_number;
    private String code;
}
