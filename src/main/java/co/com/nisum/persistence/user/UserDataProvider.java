package co.com.nisum.persistence.user;

import co.com.nisum.domain.model.user.User;

import java.util.List;

public interface UserDataProvider {

    public List<User> findAll();
    public User save(User user);
    public boolean existUserDataByEmail(String email);
    public User findByEmailAndAPassword(String email, String password);
}
