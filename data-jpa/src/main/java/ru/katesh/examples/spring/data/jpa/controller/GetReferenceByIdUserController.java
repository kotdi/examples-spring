package ru.katesh.examples.spring.data.jpa.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.katesh.examples.spring.data.jpa.entity.User;
import ru.katesh.examples.spring.data.jpa.repository.UserRepository;

@Slf4j
@RestController
@RequestMapping("/v1/user/getReferenceById")
@RequiredArgsConstructor
public class GetReferenceByIdUserController {

    private final UserRepository userRepository;

    /**
     * Метод getReferenceById возвращает "ленивый прокси" сущности, а не сам объект. Это значит, что вместо загрузки
     * всей сущности из базы, тебе вернётся "обёртка" (Hibernate proxy), которая выглядит как сущность, но на самом деле
     * не содержит данных. Данные подтянутся только при первом обращении к какому-то полю (lazy loading). Это нужно
     * использовать тогда, когда нужна ссылка на сущность, чтобы использовать её как foreign key, но данные самой
     * сущности не важны.
     */
    @GetMapping("/{userId}")
    @Transactional
    public void getReferenceById(@PathVariable Long userId) {
        log.info("Делаем запрос getReferenceById c id = {}", userId);
        User user = userRepository.getReferenceById(userId);
        log.info("Получили ссылку на объект user c id = {}, теперь выведем все поля объекта", userId);
        log.info("userId = {}", user.getUserId());
        log.info("userName = {}", user.getUserName());
        log.info("userMiddleName = {}", user.getUserMiddleName());
        log.info("userLastName = {}", user.getUserLastName());
        log.info("userBirthday = {}", user.getUserBirthday());
    }
}
