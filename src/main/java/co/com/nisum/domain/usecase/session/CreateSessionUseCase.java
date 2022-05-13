package co.com.nisum.domain.usecase.session;

import co.com.nisum.domain.model.session.Session;
import co.com.nisum.persistence.session.SessionDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateSessionUseCase {

    private final SessionDataProvider sessionDataProvider;

    public Session create(Session session) {
        return sessionDataProvider.create(session);
    }


}
