package co.com.nisum.domain.model.session;


import co.com.nisum.domain.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Session {

    private UUID sessionId;
    private String token;
    private boolean active;
    private LocalDateTime lastLogin;
    private UUID userId;
}