package co.com.nisum.persistence.phone;

import co.com.nisum.domain.model.phone.Phone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class PhoneDataProviderAdapterTest {

    @InjectMocks private PhoneDataProviderAdapter phoneDataProviderAdapter;
    @Mock        private  PhoneDataProviderData phoneDataProviderData;
    @Mock        private  PhoneMapper phoneMapper;

    private Phone phone;
    private PhoneData phoneData;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        phone = Phone.builder().cityCode("COL").number("34455").build();
        phoneData = new PhoneData();
        phoneData.setCityCode("CA");
    }


    @Test
    public void create() {
        Mockito.when(phoneMapper.toData(Mockito.any())).thenReturn(phoneData);
        Mockito.when(phoneMapper.toEntity(Mockito.any())).thenReturn(phone);
        Mockito.when(phoneDataProviderData.save(Mockito.any())).thenReturn(phoneData);
        Assertions.assertEquals(phone, phoneDataProviderAdapter.create(phone));
    }


}
