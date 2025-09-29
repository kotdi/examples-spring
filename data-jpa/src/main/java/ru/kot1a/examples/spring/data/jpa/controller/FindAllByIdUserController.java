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
@RequestMapping("/v1/user/findAllById")
@RequiredArgsConstructor
public class FindAllByIdUserController {

    private final UserRepository userRepository;

    /**
     * Метод findAllById в Spring Data JPA используется для поиска нескольких сущностей по их идентификаторам. Он
     * принимает на вход коллекцию идентификаторов (например, List, Set) и возвращает список сущностей, соответствующих
     * этим идентификаторам.
     */
    @PostMapping
    public List<User> findAllById(@RequestBody List<Long> ids) {
        return userRepository.findAllById(ids);
    }
}
