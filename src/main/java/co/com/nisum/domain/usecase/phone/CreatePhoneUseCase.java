package co.com.nisum.domain.usecase.phone;

import co.com.nisum.domain.model.phone.Phone;
import co.com.nisum.persistence.phone.PhoneDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePhoneUseCase {

    private final PhoneDataProvider phoneDataProvider;

    public Phone create(Phone phone) {
       return phoneDataProvider.create(phone);
    }

}
