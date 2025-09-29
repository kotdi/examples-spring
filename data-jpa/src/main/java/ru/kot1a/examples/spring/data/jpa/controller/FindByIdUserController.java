package ru.kot1a.examples.spring.data.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kot1a.examples.spring.data.jpa.entity.User;
import ru.kot1a.examples.spring.data.jpa.repository.UserRepository;

@RestController
@RequestMapping("/v1/user/findById")
@RequiredArgsConstructor
public class FindByIdUserController {

    private final UserRepository userRepository;

    /**
     * Метод findById - это стандартный метод репозитория, который позволяет найти сущность в базе данных по её
     * идентификатору. Возвращает объект типа Optional.
     */
    @GetMapping("/{userId}")
    public User findById(@PathVariable Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }
}
