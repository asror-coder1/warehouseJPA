package asror_uz.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
    private String  firstname;
    private String lastname;
    private String phonenumber;
    private String code;
    private String password;
}
