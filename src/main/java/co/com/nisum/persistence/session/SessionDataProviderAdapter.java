package co.com.nisum.persistence.session;

import co.com.nisum.domain.model.session.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SessionDataProviderAdapter implements  SessionDataProvider{

    private final SessionDataProviderData sessionDataProviderData;
    private final SessionMapper sessionMapper;

    @Override
    public Session create(Session session) {
        return sessionMapper.toEntity(sessionDataProviderData.save(sessionMapper.toData(session)));
    }

}
