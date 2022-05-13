package co.com.nisum.domain.usecase.user;

import co.com.nisum.domain.model.exception.BusinessException;
import co.com.nisum.domain.model.session.Login;
import co.com.nisum.domain.model.session.Session;
import co.com.nisum.domain.model.user.User;
import co.com.nisum.domain.usecase.token.GenerateTokenUseCase;
import co.com.nisum.domain.usecase.user.enums.UserErrorMessages;
import co.com.nisum.persistence.session.SessionDataProvider;
import co.com.nisum.persistence.user.UserData;
import co.com.nisum.persistence.user.UserDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LoginUseCase {

    private final GenerateTokenUseCase generateTokenUseCase;
    private final UserDataProvider userDataProvider;
    private final SessionDataProvider sessionDataProvider;

    public String login(Login login) throws BusinessException {
        User user = userDataProvider.findByEmailAndAPassword(login.getEmail(), login.getPassword());

        if(user == null) {
            throw  new BusinessException(UserErrorMessages.USER_NOT_FOUND.getValue());
        }
        String token = generateTokenUseCase.generate(login);
        Session session =
                Session.builder()
                        .userId(user.getId())
                        .token(token)
                        .active(Boolean.TRUE)
                        .lastLogin(LocalDateTime.now())
                        .build();
        sessionDataProvider.create(session);
        return token;

    }
}
