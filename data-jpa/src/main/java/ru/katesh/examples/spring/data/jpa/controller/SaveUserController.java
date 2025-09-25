package ru.katesh.examples.spring.data.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.katesh.examples.spring.data.jpa.entity.User;
import ru.katesh.examples.spring.data.jpa.repository.UserRepository;

@RestController
@RequestMapping("/v1/user/save")
@RequiredArgsConstructor
public class SaveUserController {

    private final UserRepository userRepository;

    /**
     * Метод save используется для сохранения сущности в базе данных. Он может как добавлять новую запись, так и
     * обновлять существующую, в зависимости от того, есть ли у сущности идентификатор id
     */
    @PostMapping
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }
}
