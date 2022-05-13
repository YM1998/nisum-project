package co.com.nisum.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserDataProviderData extends JpaRepository<UserData, UUID> {

    public boolean existsByEmail(String email);
    public UserData findByEmailAndPassword(String email, String password);
}
