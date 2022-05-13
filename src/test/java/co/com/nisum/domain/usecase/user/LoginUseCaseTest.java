package co.com.nisum.domain.usecase.user;

import co.com.nisum.domain.model.exception.BusinessException;
import co.com.nisum.domain.model.session.Login;
import co.com.nisum.domain.model.user.User;
import co.com.nisum.domain.usecase.token.GenerateTokenUseCase;
import co.com.nisum.domain.usecase.user.enums.UserErrorMessages;
import co.com.nisum.persistence.session.SessionDataProvider;
import co.com.nisum.persistence.user.UserDataProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class LoginUseCaseTest {

    @InjectMocks private LoginUseCase loginUseCase;
    @Mock private  GenerateTokenUseCase generateTokenUseCase;
    @Mock private  UserDataProvider userDataProvider;
    @Mock private  SessionDataProvider sessionDataProvider;

    private User user;
    private Login login;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        user = User.builder()
                .created(LocalDateTime.now())
                .email("yesidmurillosegura@hotmail.com")
                .id(UUID.randomUUID())
                .name("yesid")
                .password("ssssDDd@1998*")
                .updated(LocalDateTime.now())
                .build();

        login = Login.builder().email("yesid").password("1233").build();
    }

    @Test
    public void invalidCredentials() {
        BusinessException thrown = assertThrows(BusinessException.class,
                ()-> loginUseCase.login(login));
        assertEquals(UserErrorMessages.USER_NOT_FOUND.getValue(), thrown.getMessage());

    }

    @Test
    public void login() throws BusinessException {
        String token = "XXXXXXXX";

        Mockito.when(userDataProvider.findByEmailAndAPassword(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(user);
        Mockito.when(generateTokenUseCase.generate(Mockito.any()))
                .thenReturn(token);

        String result = loginUseCase.login(login);

        assertAll(() -> assertEquals(token, result),
                () -> Mockito.verify(sessionDataProvider).create(Mockito.any()));

    }


}
