package ru.katesh.examples.spring.data.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.katesh.examples.spring.data.jpa.entity.User;
import ru.katesh.examples.spring.data.jpa.repository.UserRepository;

@RestController
@RequestMapping("/v1/user/findOne")
@RequiredArgsConstructor
public class FindOneUserController {

    private final UserRepository userRepository;

    /**
     * Метод findOne возвращает запись, соответсвующую примеру в аргументе метода. Запись должна быть уникальной, иначе
     * будет выброшен IncorrectResultSizeDataAccessException. При выполнении запроса просит вернуть 2 записи для
     * проверки уникальности
     */
    @GetMapping
    public User findOne(@RequestParam String name,
                        @RequestParam String middleName) {
        User user = new User();
        user.setUserName(name);
        user.setUserMiddleName(middleName);
        Example<User> userExample = Example.of(user);
        return userRepository.findOne(userExample).orElseThrow();
    }
}
