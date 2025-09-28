package ru.kot1a.examples.spring.data.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kot1a.examples.spring.data.jpa.repository.UserRepository;

@RestController
@RequestMapping("/v1/user/deleteById")
@RequiredArgsConstructor
public class DeleteByIdUserController {

    private final UserRepository userRepository;

    /**
     * Метод deleteById в Spring Data JPA используется для удаления сущности из базы данных по её идентификатору
     */
    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable Long userId) {
        userRepository.deleteById(userId);
    }
}
