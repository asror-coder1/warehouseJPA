package asror_uz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  firstname;
    private String lastname;
    @Column(nullable = false , unique = true)
    private String phonenumber;
    private String code;
    private String password;
    private Boolean active = true;
    private LocalDateTime createddate = LocalDateTime.now();

}
