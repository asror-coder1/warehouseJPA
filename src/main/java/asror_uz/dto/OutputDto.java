package asror_uz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputDto {
    private String date;
    private Long warehouse_id;
    private Long currency_id;
    private String facture_number;
    private String code;
    private Long client_id;
}
