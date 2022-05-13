package co.com.nisum.persistence.phone;

import co.com.nisum.persistence.user.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PhoneDataProviderData extends JpaRepository<PhoneData, UUID> {
}
