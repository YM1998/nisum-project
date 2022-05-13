package co.com.nisum.domain.usecase.user;

import co.com.nisum.domain.model.enums.Patterns;
import co.com.nisum.domain.model.exception.BusinessException;
import co.com.nisum.domain.model.phone.Phone;
import co.com.nisum.domain.model.session.Login;
import co.com.nisum.domain.model.session.Session;
import co.com.nisum.domain.model.user.User;
import co.com.nisum.domain.model.user.UserResponseCreated;
import co.com.nisum.domain.usecase.common.ValidatePattern;
import co.com.nisum.domain.usecase.session.CreateSessionUseCase;
import co.com.nisum.domain.usecase.token.GenerateTokenUseCase;
import co.com.nisum.domain.usecase.user.enums.UserErrorMessages;
import co.com.nisum.persistence.phone.PhoneData;
import co.com.nisum.persistence.phone.PhoneDataProvider;
import co.com.nisum.persistence.user.UserDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase {

    private final UserDataProvider userDataProvider;
    private final PhoneDataProvider phoneDataProvider;
    private final CreateSessionUseCase createSessionUseCase;
    private final GenerateTokenUseCase generateTokenUseCase;

    public UserResponseCreated create(User user, List<Phone> phones) throws BusinessException {
        validatePattern(user);
        validateExistEmail(user);
        User userResponse = userDataProvider.save(user);
        createPhones(userResponse, phones);
        Session session = createSession(userResponse);
        return buildUserResponseCreated(userResponse, session);
    }

    private void validatePattern(User user) throws BusinessException {
        if(!ValidatePattern.validate(user.getEmail(), Patterns.VALID_EMAIL.getValue())) {
            throw  new BusinessException(UserErrorMessages.INVALID_EMAIL.getValue());
        }

        if(!ValidatePattern.validate(user.getPassword(), Patterns.VALID_PASSWORD.getValue())) {
            throw  new BusinessException(UserErrorMessages.INVALID_PASSWORD.getValue());
        }
    }

    private void validateExistEmail(User user) throws BusinessException {
       if(userDataProvider.existUserDataByEmail(user.getEmail())) {
           throw  new BusinessException(UserErrorMessages.ACCOUNT_EXIST.getValue());
       }
    }

    private void createPhones(User user, List<Phone> phones) {
        phones.stream().forEach(phone -> {
            phone.setUserId(user.getId());
            phoneDataProvider.create(phone);
        });
    }

    private Session createSession(User user) {
        return createSessionUseCase
                .create(Session.builder()
                               .lastLogin(LocalDateTime.now())
                               .token(generateTokenUseCase.generate(Login.builder().email(user.getEmail()).build()))
                               .userId(user.getId())
                               .active(Boolean.TRUE)
                               .build());
    }

    private UserResponseCreated buildUserResponseCreated(User user, Session session) {
        return UserResponseCreated
                .builder()
                .id(user.getId())
                .created(user.getCreated())
                .modified(user.getUpdated())
                .lastLogin(session.getLastLogin())
                .isActive(session.isActive())
                .token(session.getToken())
                .build();
    }



}
