package co.com.nisum.persistence.session;


import co.com.nisum.domain.model.session.Session;
import co.com.nisum.persistence.phone.PhoneData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class SessionDataProviderAdapterTest {

    @InjectMocks  private SessionDataProviderAdapter sessionDataProviderAdapter;
    @Mock  private SessionDataProviderData sessionDataProviderData;
    @Mock  private SessionMapper sessionMapper;

    private Session session;
    private SessionData sessionData;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        session = Session.builder().token("XXX").active(Boolean.TRUE).build();
        sessionData = new SessionData();
        sessionData.setToken("XXX");
        sessionData.setActive(Boolean.TRUE);
    }


    @Test
    public void create() {
        Mockito.when(sessionMapper.toData(Mockito.any())).thenReturn(sessionData);
        Mockito.when(sessionMapper.toEntity(Mockito.any())).thenReturn(session);
        Mockito.when(sessionDataProviderData.save(Mockito.any())).thenReturn(sessionData);
        Assertions.assertEquals(session, sessionDataProviderAdapter.create(session));
    }


}

