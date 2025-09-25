package ru.katesh.examples.spring.data.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.katesh.examples.spring.data.jpa.repository.UserRepository;

@RestController
@RequestMapping("/v1/user/count")
@RequiredArgsConstructor
public class CountUserController {

    private final UserRepository userRepository;

    /**
     * Метод count подсчитывает количество записей в таблице
     */
    @GetMapping
    public Long count() {
        return userRepository.count();
    }
}
