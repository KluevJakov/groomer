package my.company.groomer.services;

import my.company.groomer.domains.Role;
import my.company.groomer.domains.User;
import my.company.groomer.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public boolean register(User user) {
        Optional<User> fetchedUser = userRepository.findByEmail(user.getEmail());
        if (fetchedUser.isPresent()) {
            return false;
        }
        Role clientRole = new Role();
        clientRole.setId(2L);
        user.setRoles(Collections.singleton(clientRole));
        userRepository.save(user);
        return true;
    }

    public User login(User user) {
        Optional<User> fetchedUser = userRepository.findByEmail(user.getEmail());
        if (fetchedUser.isEmpty()) {
            return null;
        }
        if (fetchedUser.get().getPassword().equals(user.getPassword())) {
            return fetchedUser.get();
        }
        return null;
    }
}
