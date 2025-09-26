package ru.katesh.examples.spring.data.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.katesh.examples.spring.data.jpa.entity.User;
import ru.katesh.examples.spring.data.jpa.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/v1/user/saveAllAndFlush")
@RequiredArgsConstructor
public class SaveAllAndFlushUserController {

    private final UserRepository userRepository;

    /**
     * Метод saveAllAndFlush используется, когда нужно сохранить пачку и тут же выгрузить в базу, а не ждать commit
     * транзакции.
     */
    @PostMapping
    public List<User> saveAllAndFlush(@RequestBody List<User> users) {
        return userRepository.saveAllAndFlush(users);
    }
}
