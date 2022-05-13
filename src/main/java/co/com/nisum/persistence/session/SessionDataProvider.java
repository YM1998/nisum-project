package co.com.nisum.persistence.session;

import co.com.nisum.domain.model.session.Session;

public interface SessionDataProvider {

    public  Session create(Session session);
}
