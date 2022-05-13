package co.com.nisum.domain.usecase.user;

import co.com.nisum.domain.model.exception.BusinessException;
import co.com.nisum.domain.model.phone.Phone;
import co.com.nisum.domain.model.session.Session;
import co.com.nisum.domain.model.user.User;
import co.com.nisum.domain.model.user.UserResponseCreated;
import co.com.nisum.domain.usecase.session.CreateSessionUseCase;
import co.com.nisum.domain.usecase.token.GenerateTokenUseCase;
import co.com.nisum.domain.usecase.user.enums.UserErrorMessages;
import co.com.nisum.persistence.phone.PhoneDataProvider;
import co.com.nisum.persistence.user.UserDataProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.omg.CORBA.portable.ApplicationException;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class CreateUserUseCaseTest {


    @InjectMocks private CreateUserUseCase createUserUseCase;
    @Mock        private UserDataProvider userDataProvider;
    @Mock        private PhoneDataProvider phoneDataProvider;
    @Mock        private CreateSessionUseCase createSessionUseCase;
    @Mock        private GenerateTokenUseCase generateTokenUseCase;

    private User user;
    private List<Phone> phones;
    private Session session;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        user = User.builder()
                .created(LocalDateTime.now())
                .email("yesidmurillosegura@hotmail.com")
                .id(UUID.randomUUID())
                .name("yesid")
                .password("ssssDDd@1998*")
                .updated(LocalDateTime.now())
                .build();

        phones = Collections.singletonList(Phone.builder().cityCode("0003").countryCode("COL").number("33445").build());

        session = Session.builder().lastLogin(LocalDateTime.now()).active(Boolean.TRUE).token("XXX").build();


    }

    @Test
    public void emailInvalid() throws BusinessException {
        user.setEmail("correoinvalido");
        BusinessException thrown = assertThrows(BusinessException.class,
                ()-> createUserUseCase.create(user, phones));
        assertEquals(UserErrorMessages.INVALID_EMAIL.getValue(), thrown.getMessage());
    }

    @Test
    public void passwordInvalid() throws BusinessException {
        user.setPassword("passwordinvalida");
        BusinessException thrown = assertThrows(BusinessException.class,
                ()-> createUserUseCase.create(user, phones));
        assertEquals(UserErrorMessages.INVALID_PASSWORD.getValue(), thrown.getMessage());
    }

    @Test
    public void accountExist() throws BusinessException {
        Mockito.when(userDataProvider.existUserDataByEmail(Mockito.anyString()))
                .thenReturn(Boolean.TRUE);
        BusinessException thrown = assertThrows(BusinessException.class,
                ()-> createUserUseCase.create(user, phones));
        assertEquals(UserErrorMessages.ACCOUNT_EXIST.getValue(), thrown.getMessage());
    }


    @Test
    public void createUser() throws BusinessException {
        Mockito.when(userDataProvider.save(Mockito.any())).thenReturn(user);
        Mockito.when(createSessionUseCase.create(Mockito.any())).thenReturn(session);
        UserResponseCreated userResponseCreated = createUserUseCase.create(user, phones);
        assertAll(() -> assertEquals(user.getId(), userResponseCreated.getId()),
                  () -> assertEquals(session.getToken(), userResponseCreated.getToken()));

    }







}
