package co.com.nisum.api.user;

import co.com.nisum.api.common.Response;
import co.com.nisum.api.user.request.UserPhoneRequest;
import co.com.nisum.api.user.request.UserRequest;
import co.com.nisum.domain.model.exception.BusinessException;
import co.com.nisum.domain.model.phone.Phone;
import co.com.nisum.domain.model.session.Login;
import co.com.nisum.domain.model.user.User;
import co.com.nisum.domain.usecase.user.CreateUserUseCase;
import co.com.nisum.domain.usecase.user.GetUsersUseCase;
import co.com.nisum.domain.usecase.user.LoginUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController implements UserService {

    private final GetUsersUseCase getUsersUseCase;
    private final CreateUserUseCase createUserUseCase;
    private final LoginUseCase loginUseCase;

    @Override
    public ResponseEntity<Response> getUsers() {
        return ResponseEntity.ok(new Response(getUsersUseCase.getAll()));
    }

    @Override
    public ResponseEntity<Response> create(UserRequest userRequest) throws BusinessException {
        return ResponseEntity.ok(new Response(createUserUseCase.create(
                buildUser(userRequest), buildPhones(userRequest.getPhones()))));
    }

    @Override
    public ResponseEntity<Map<String, String>> login(Login login) throws BusinessException {
        Map<String, String> result = new HashMap<>();
        result.put("token", loginUseCase.login(login));
        return ResponseEntity.ok(result);
    }


    private User buildUser(UserRequest userRequest) {
        return User.builder()
                   .name(userRequest.getEmail())
                   .email(userRequest.getEmail())
                   .password(userRequest.getPassword())
                   .build();
    }

    private List<Phone> buildPhones(List<UserPhoneRequest> userPhoneRequests) {
        return userPhoneRequests.stream().map(userPhoneRequest ->
                Phone.builder()
                     .cityCode(userPhoneRequest.getCityCode())
                     .countryCode(userPhoneRequest.getCountryCode())
                     .number(userPhoneRequest.getNumber())
                     .build()).collect(Collectors.toList());
    }

}
