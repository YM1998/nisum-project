package co.com.nisum.persistence.phone;

import co.com.nisum.domain.model.phone.Phone;
import org.springframework.stereotype.Component;

@Component
public class PhoneMapper {

    public Phone toEntity(PhoneData phoneData) {
        return Phone.builder()
                .id(phoneData.getId())
                .cityCode(phoneData.getCityCode())
                .number(phoneData.getNumber())
                .userId(phoneData.getUserId())
                .build();
    }

    public PhoneData toData(Phone phone) {
        PhoneData phoneData = new PhoneData();
        phoneData.setId(phone.getId());
        phoneData.setCityCode(phone.getCityCode());
        phoneData.setNumber(phone.getNumber());
        phoneData.setUserId(phone.getUserId());
        return phoneData;
    }
}
