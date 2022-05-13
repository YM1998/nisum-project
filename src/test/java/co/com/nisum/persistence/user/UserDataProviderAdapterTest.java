package co.com.nisum.persistence.user;

import co.com.nisum.domain.model.session.Session;
import co.com.nisum.domain.model.user.User;
import co.com.nisum.persistence.session.SessionData;
import co.com.nisum.persistence.session.SessionDataProviderAdapter;
import co.com.nisum.persistence.session.SessionDataProviderData;
import co.com.nisum.persistence.session.SessionMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class UserDataProviderAdapterTest {

    @InjectMocks private UserDataProviderAdapter userDataProviderAdapter;
    @Mock private UserDataProviderData userDataProviderData;
    @Mock private UserMapper userMapper;

    private User user;
    private UserData userData;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        user = User.builder().name("yes").build();
        userData = new UserData();
        userData.setName("yes");
    }


    @Test
    public void create() {
        Mockito.when(userMapper.toData(Mockito.any())).thenReturn(userData);
        Mockito.when(userMapper.toEntity(Mockito.any())).thenReturn(user);
        Mockito.when(userDataProviderData.save(Mockito.any())).thenReturn(userData);
        Assertions.assertEquals(user, userDataProviderAdapter.save(user));
    }

    @Test
    public void existUserDataByEmail() {
        Mockito.when(userDataProviderData.existsByEmail(Mockito.anyString()))
                .thenReturn(Boolean.TRUE);
        Assertions.assertTrue(userDataProviderAdapter.existUserDataByEmail("yyy@hotmail.com"));
    }

}

