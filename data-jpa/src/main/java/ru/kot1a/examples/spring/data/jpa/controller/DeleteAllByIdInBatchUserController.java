package ru.kot1a.examples.spring.data.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kot1a.examples.spring.data.jpa.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/v1/user/deleteAllByIdInBatch")
@RequiredArgsConstructor
public class DeleteAllByIdInBatchUserController {

    private final UserRepository userRepository;

    /**
     * Метод deleteAllByIdInBatch удаляет сущности по ids одним запросом через IN
     */
    @DeleteMapping
    public void deleteAllByIdInBatch(@RequestBody List<Long> ids) {
        userRepository.deleteAllByIdInBatch(ids);
    }
}
