package ru.kot1a.examples.spring.data.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kot1a.examples.spring.data.jpa.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/v1/user/deleteAllById")
@RequiredArgsConstructor
public class DeleteAllByIdUserController {

    private final UserRepository userRepository;

    /**
     * Метод deleteAllById в Spring Data JPA используется для удаления нескольких сущностей из базы данных по их
     * идентификаторам. Он принимает на вход коллекцию идентификаторов (например, List<Long>, Set<Integer>) и удаляет
     * все сущности, соответствующие этим id. Если какой-то id не существует, он просто игнорируется. Важное замечание,
     * ORM генерит много отдельных DELETE запросов
     */
    @DeleteMapping
    public void deleteAllById(@RequestBody List<Long> ids) {
        userRepository.deleteAllById(ids);
    }
}
