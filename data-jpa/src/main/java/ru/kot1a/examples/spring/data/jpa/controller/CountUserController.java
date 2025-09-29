package ru.kot1a.examples.spring.data.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kot1a.examples.spring.data.jpa.entity.User;
import ru.kot1a.examples.spring.data.jpa.repository.UserRepository;

@RestController
@RequestMapping("/v1/user/count")
@RequiredArgsConstructor
public class CountUserController {

    private final UserRepository userRepository;

    /**
     * Метод count подсчитывает количество записей в таблице.
     */
    @GetMapping
    public Long count() {
        return userRepository.count();
    }

    /**
     * Метод count подсчитывает количество записей в таблице соответствующих примеру в аргументе example.
     */
    @GetMapping("/example")
    public Long countWithExample(@RequestParam String name) {
        User user = new User();
        user.setUserName(name);
        Example<User> userExample = Example.of(user);
        return userRepository.count(userExample);
    }
}
