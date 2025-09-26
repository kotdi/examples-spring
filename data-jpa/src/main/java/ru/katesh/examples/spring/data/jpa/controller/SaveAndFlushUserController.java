package ru.katesh.examples.spring.data.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.katesh.examples.spring.data.jpa.entity.User;
import ru.katesh.examples.spring.data.jpa.repository.UserRepository;

@RestController
@RequestMapping("/v1/user/saveAndFlush")
@RequiredArgsConstructor
public class SaveAndFlushUserController {

    private final UserRepository userRepository;

    /**
     * Метод saveAndFlush заставляет Hibernate синхронизировать persistence context с базой. В этот момент Hibernate
     * берёт все накопленные изменения (INSERT, UPDATE, DELETE) и исполняет SQL
     */
    @PostMapping
    public User saveAndFlush(@RequestBody User user) {
        return userRepository.saveAndFlush(user);
    }
}
