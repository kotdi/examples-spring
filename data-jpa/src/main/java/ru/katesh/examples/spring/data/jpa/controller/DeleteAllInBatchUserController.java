package ru.katesh.examples.spring.data.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.katesh.examples.spring.data.jpa.entity.User;
import ru.katesh.examples.spring.data.jpa.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/v1/user/deleteAllInBatch")
@RequiredArgsConstructor
public class DeleteAllInBatchUserController {

    private final UserRepository userRepository;

    /**
     * Метод deleteAllInBatch удаляет все записи одним запросом
     */
    @DeleteMapping
    public void deleteAll() {
        userRepository.deleteAllInBatch();
    }

    /**
     * Метод deleteAllInBatch удаляет переданные ему сущности одним запросом через IN
     */
    @DeleteMapping("/ids")
    public void deleteAllFromCollection(@RequestBody List<Long> ids) {
        List<User> users = userRepository.findAllById(ids);
        userRepository.deleteAllInBatch(users);
    }
}
