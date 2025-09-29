package ru.kot1a.examples.spring.data.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kot1a.examples.spring.data.jpa.entity.User;
import ru.kot1a.examples.spring.data.jpa.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/v1/user/deleteAll")
@RequiredArgsConstructor
public class DeleteAllUserController {

    private final UserRepository userRepository;

    /**
     * Метод deleteAll удаляет все записи, применяя к каждой отдельный DELETE запрос.
     */
    @DeleteMapping
    public void deleteAll() {
        userRepository.deleteAll();
    }

    /**
     * Метод deleteAll удаляет переданные ему сущности.
     */
    @DeleteMapping("/ids")
    public void deleteAllFromCollection(@RequestBody List<Long> ids) {
        List<User> users = userRepository.findAllById(ids);
        userRepository.deleteAll(users);
    }
}
