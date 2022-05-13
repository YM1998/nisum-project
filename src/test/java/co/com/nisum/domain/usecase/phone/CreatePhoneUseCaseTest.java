package co.com.nisum.domain.usecase.phone;

import co.com.nisum.domain.model.phone.Phone;
import co.com.nisum.persistence.phone.PhoneDataProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CreatePhoneUseCaseTest {

    @InjectMocks  private CreatePhoneUseCase createPhoneUseCase;
    @Mock         private PhoneDataProvider phoneDataProvider;

    private Phone phone;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        phone = Phone.builder().cityCode("COL").number("34455").build();
    }

    @Test
    public void create() {
        Mockito.when(phoneDataProvider.create(Mockito.any())).thenReturn(phone);
        Assertions.assertEquals(phone, createPhoneUseCase.create(phone));
    }

}
