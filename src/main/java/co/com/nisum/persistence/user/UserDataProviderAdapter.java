package co.com.nisum.persistence.user;

import co.com.nisum.domain.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserDataProviderAdapter implements  UserDataProvider{

    private final UserDataProviderData userRepository;
    private final UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public User save(User user) {
        return userMapper.toEntity(userRepository.save(userMapper.toData(user)));
    }

    @Override
    public boolean existUserDataByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User findByEmailAndAPassword(String email, String password) {
        UserData userData = userRepository.findByEmailAndPassword(email, password);
        return userData !=null ? userMapper.toEntity(userData) : null;
    }


}
