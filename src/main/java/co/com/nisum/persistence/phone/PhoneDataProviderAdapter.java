package co.com.nisum.persistence.phone;

import co.com.nisum.domain.model.phone.Phone;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PhoneDataProviderAdapter implements PhoneDataProvider{

    private final PhoneDataProviderData phoneDataProviderData;
    private final PhoneMapper phoneMapper;

    @Override
    public Phone create(Phone phone) {
        return phoneMapper.toEntity(phoneDataProviderData.save(phoneMapper.toData(phone)));
    }
}
