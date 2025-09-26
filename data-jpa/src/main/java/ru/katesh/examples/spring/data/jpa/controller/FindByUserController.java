package ru.katesh.examples.spring.data.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.katesh.examples.spring.data.jpa.repository.UserRepository;

@RestController
@RequestMapping("/v1/user/findBy")
@RequiredArgsConstructor
public class FindByUserController {

    private final UserRepository userRepository;

    /**
     * Метод findBy
     */
    @GetMapping
    public void findBy() {
        //TODO реализовать пример работы метода
        //return userRepository.findBy();
    }
}
