package co.com.nisum.domain.usecase.token;

import co.com.nisum.domain.model.session.Login;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GenerateTokenUseCaseTest {


    @Test
    public void generateToken(){
        Assertions.assertNotNull(new GenerateTokenUseCase().generate(Login.builder()
                .email("yyy@hotmail.com").build()));
    }

}
