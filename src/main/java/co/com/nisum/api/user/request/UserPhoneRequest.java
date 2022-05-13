package co.com.nisum.api.user.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserPhoneRequest {

    private String number;
    private String cityCode;
    private String countryCode;
}
