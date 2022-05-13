package co.com.nisum.persistence.session;


import co.com.nisum.domain.model.session.Session;
import org.springframework.stereotype.Component;

@Component
public class SessionMapper {

    public Session toEntity(SessionData sessionData) {
        return Session.builder()
                .sessionId(sessionData.getSessionId())
                .active(sessionData.isActive())
                .lastLogin(sessionData.getLastLogin())
                .userId(sessionData.getUserId())
                .token(sessionData.getToken())
                .build();
    }

    public SessionData toData(Session session) {
        SessionData sessionData = new SessionData();
        sessionData.setSessionId(session.getSessionId());
        sessionData.setUserId(session.getUserId());
        sessionData.setActive(session.isActive());
        sessionData.setToken(session.getToken());
        sessionData.setLastLogin(session.getLastLogin());
        return sessionData;
    }
}
