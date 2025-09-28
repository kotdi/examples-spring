package ru.kot1a.examples.spring.data.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kot1a.examples.spring.data.jpa.entity.User;
import ru.kot1a.examples.spring.data.jpa.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/v1/user/saveAll")
@RequiredArgsConstructor
public class SaveAllUserController {

    private final UserRepository userRepository;

    /**
     * Метод saveAll сохраняет сущности в базу данных, вызывая для каждой в цикле метод save. Можно включить batching,
     * но он не работает с INSERT, если у сущности GenerationType.IDENTITY, но работает с UPDATE
     */
    @PostMapping
    public List<User> saveAll(@RequestBody List<User> users) {
        return userRepository.saveAll(users);
    }
}
