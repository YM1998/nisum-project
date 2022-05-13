package co.com.nisum.domain.model.phone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Phone {
    private UUID id;
    private String number;
    private String cityCode;
    private String countryCode;
    private UUID userId;
}
