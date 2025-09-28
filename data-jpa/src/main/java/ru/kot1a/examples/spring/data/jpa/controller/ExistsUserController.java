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
@RequestMapping("/v1/user/exists")
@RequiredArgsConstructor
public class ExistsUserController {

    private final UserRepository userRepository;

    /**
     * Метод exists проверяет, существует ли сущность в базе данных с указанным примером. Возвращает boolean
     */
    @GetMapping
    public boolean exists(@RequestParam String name,
                          @RequestParam String middleName) {
        User user = new User();
        user.setUserName(name);
        user.setUserMiddleName(middleName);
        Example<User> userExample = Example.of(user);
        return userRepository.exists(userExample);
    }
}
