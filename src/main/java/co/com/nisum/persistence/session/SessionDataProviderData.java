package co.com.nisum.persistence.session;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SessionDataProviderData extends JpaRepository<SessionData, UUID> {


}
