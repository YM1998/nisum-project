package co.com.nisum.persistence.session;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "sessions", schema = "public")
public class SessionData {

    @Id
    @Column(name = "session_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID sessionId;

    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "is_active", nullable = false)
    private boolean active ;

    @Column(name = "last_login", nullable = false)
    private LocalDateTime lastLogin;

    @Column(name = "user_id")
    private UUID userId;
}
