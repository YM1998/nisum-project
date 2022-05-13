package co.com.nisum.api.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class Response {

    private String message;
    private Integer state;
    private Object data;

    public Response(Object data) {
        this.data = data;
        this.message = "Ok";
        this.state = HttpStatus.OK.value();
    }


    public Response(String message, Integer state, Object data) {
        this.message = message;
        this.state = state;
        this.data = data;
    }
}
