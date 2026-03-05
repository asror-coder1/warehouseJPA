package asror_uz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Input_ProductDto {
    private Long product_id;
    private String amount;
    private String price;
    private String expire_date;
    private Long input_id;
}
