package ru.kot1a.examples.spring.data.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kot1a.examples.spring.data.jpa.repository.UserRepository;

@RestController
@RequestMapping("/v1/user/existsById")
@RequiredArgsConstructor
public class ExistsByIdUserController {

    private final UserRepository userRepository;

    /**
     * Метод existsById проверяет, существует ли сущность в базе данных с указанным идентификатором. Возвращает boolean
     */
    @GetMapping("/{userId}")
    public boolean existsById(@PathVariable Long userId) {
        return userRepository.existsById(userId);
    }
}
