package co.com.nisum.api.user.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequest {

    @NotEmpty(message = "diligenciar el campo name")
    private String name;
    @NotEmpty(message = "diligenciar el campo email")
    private String email;
    @NotEmpty(message = "diligenciar el campo password")
    private String password;
    @NotEmpty(message = "enviar los telefonos")
    private List<UserPhoneRequest> phones;
}
