package co.com.nisum.persistence.user;

import co.com.nisum.domain.model.user.User;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    public User toEntity(UserData userData) {
        return User.builder()
                .created(userData.getCreated())
                .id(userData.getId())
                .email(userData.getEmail())
                .name(userData.getName())
                .password(userData.getPassword())
                .updated(userData.getUpdated())
                .build();
    }

    public UserData toData(User user) {
       UserData userData = new UserData();
       userData.setCreated(user.getCreated());
       userData.setId(user.getId());
       userData.setEmail(user.getEmail());
       userData.setName(user.getName());
       userData.setPassword(user.getPassword());
       userData.setUpdated(user.getUpdated());
       return userData;
    }


}