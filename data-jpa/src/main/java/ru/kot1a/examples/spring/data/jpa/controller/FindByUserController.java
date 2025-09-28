package ru.kot1a.examples.spring.data.jpa.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kot1a.examples.spring.data.jpa.entity.User;
import ru.kot1a.examples.spring.data.jpa.repository.UserRepository;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/user/findBy")
@RequiredArgsConstructor
public class FindByUserController {

    private final UserRepository userRepository;

    /**
     * Метод findBy используя example с ExampleMatcher и гибкую настройку через fluentQuery динамически строит запрос
     */
    @GetMapping
    public List<User> findBy(@RequestParam String name,
                             @RequestParam String lastName,
                             @RequestParam Integer pageNumber) {
        User user = new User();
        user.setUserName(name);
        user.setUserLastName(lastName);

        //Описывает как сравнивать элементы в example
        ExampleMatcher matcher = ExampleMatcher.matching()
                //строгое сравнение
                .withMatcher("userName", ExampleMatcher.GenericPropertyMatchers.exact())
                //содержит ли подстроку - LIKE
                .withMatcher("userLastName", ExampleMatcher.GenericPropertyMatchers.contains());

        Example<User> example = Example.of(user, matcher);

        Page<User> page = userRepository.findBy(
                example,
                query -> query
                        //задаем сортировку
                        .sortBy(Sort.by(Sort.Direction.ASC, "userName")
                                .and(Sort.by(Sort.Direction.DESC,"userMiddleName")))
                        //устанавливаем пагинацию
                        .page(PageRequest.of(pageNumber, 10))

        );
        return page.getContent();
    }
}
