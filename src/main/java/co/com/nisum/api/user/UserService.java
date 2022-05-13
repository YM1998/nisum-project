package co.com.nisum.api.user;

import co.com.nisum.api.common.Response;
import co.com.nisum.api.user.request.UserRequest;
import co.com.nisum.domain.model.exception.BusinessException;
import co.com.nisum.domain.model.session.Login;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "REST API para gestion de usuarios")
@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public interface UserService {

    @ApiOperation(value = "Metodo para obtener todos los usuarios")
    @GetMapping(produces = "application/json")
    public ResponseEntity<Response> getUsers();

    @ApiOperation(value = "Metodo para guardar los usuarios")
    @PostMapping(produces = "application/json")
    public ResponseEntity<Response> create(@RequestBody @Valid UserRequest userRequest) throws BusinessException;

    @ApiOperation(value = "Metodo para loguearse y obtener el token ")
    @PostMapping(path = "/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Login login) throws BusinessException;

}
