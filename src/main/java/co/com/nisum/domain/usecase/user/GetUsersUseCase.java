package co.com.nisum.domain.usecase.user;

import co.com.nisum.domain.model.user.User;
import co.com.nisum.persistence.user.UserDataProvider;
import co.com.nisum.persistence.user.UserDataProviderAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetUsersUseCase {

    private final UserDataProvider userDataProvider;

    public List<User> getAll() {
        return userDataProvider.findAll();
    }


}
