package org.krjr.usersubscriptions.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.krjr.usersubscriptions.entity.User;
import org.krjr.usersubscriptions.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User create(User user) {
        try {
            log.info("Creating new user....");
            User savedUser = userRepository.save(user);
            log.info("User created successfully....");
            return savedUser;
        } catch (Exception e) {
            log.error("Error saving user: {}", user, e);
            throw new RuntimeException("Error saving user");
        }
    }

    public Optional<User> get(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public User update(Long id, User updated) {
        return userRepository.findById(id)
                .map(user -> {
                    if (updated.getFirstName() != null) {
                        user.setFirstName(updated.getFirstName());
                    }
                    if (updated.getLastName() != null) {
                        user.setLastName(updated.getLastName());
                    }
                    if (updated.getEmail() != null) {
                        user.setEmail(updated.getEmail());
                    }
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new IllegalArgumentException("User with id " + id + " not found"));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}

