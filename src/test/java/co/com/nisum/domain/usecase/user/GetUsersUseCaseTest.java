package co.com.nisum.domain.usecase.user;

import co.com.nisum.domain.model.user.User;
import co.com.nisum.persistence.user.UserDataProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

public class GetUsersUseCaseTest {

    @InjectMocks  private GetUsersUseCase getUsersUseCase;
    @Mock private UserDataProvider userDataProvider;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAll() {
        List<User> users = Collections.emptyList();
        Mockito.when(userDataProvider.findAll()).thenReturn(users);
        Assertions.assertEquals(users, getUsersUseCase.getAll());
    }

}
