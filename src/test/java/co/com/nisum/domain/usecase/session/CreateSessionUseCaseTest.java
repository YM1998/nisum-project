package co.com.nisum.domain.usecase.session;


import co.com.nisum.domain.model.session.Session;
import co.com.nisum.persistence.session.SessionDataProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

public class CreateSessionUseCaseTest {

    @InjectMocks private CreateSessionUseCase createSessionUseCase;
    @Mock        private SessionDataProvider sessionDataProvider;

    private Session session;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        session = Session.builder().lastLogin(LocalDateTime.now()).active(Boolean.TRUE).token("XXX").build();
    }

    @Test
    public void create() {
        Mockito.when(sessionDataProvider.create(Mockito.any())).thenReturn(session);
        Assertions.assertEquals(session, createSessionUseCase.create(session));
    }

}
