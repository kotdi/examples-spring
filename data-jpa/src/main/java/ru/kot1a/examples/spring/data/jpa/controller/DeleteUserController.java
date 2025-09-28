package ru.kot1a.examples.spring.data.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kot1a.examples.spring.data.jpa.entity.User;
import ru.kot1a.examples.spring.data.jpa.repository.UserRepository;

@RestController
@RequestMapping("/v1/user/delete")
@RequiredArgsConstructor
public class DeleteUserController {

    private final UserRepository userRepository;

    /**
     * Метод delete
     */
    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long userId) {
        User user = userRepository.getReferenceById(userId);
        userRepository.delete(user);
    }
}
