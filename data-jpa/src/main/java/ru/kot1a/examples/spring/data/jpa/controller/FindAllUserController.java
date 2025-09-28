package ru.kot1a.examples.spring.data.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kot1a.examples.spring.data.jpa.entity.User;
import ru.kot1a.examples.spring.data.jpa.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/v1/user/findAll")
@RequiredArgsConstructor
public class FindAllUserController {

    private final UserRepository userRepository;

    /**
     * Метод finaAll возвращает все записи таблицы. Опасен на больших таблицах, вытаскивает все строки, например на
     * таблице с 10 млн строк будет OutOfMemoryError или очень долгий запрос
     */
    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * Демонстрация работы метода findAll с сортировкой, в качестве properties в методе Sort.by указываются поля класса
     */
    @GetMapping("/sort")
    public List<User> findAllWithSort(@RequestParam String field) {
        return userRepository.findAll(Sort.by(Sort.Direction.DESC, field));
    }

    /**
     * Демонстрация работы метода findAll с пагинацией. Нумерация страниц начинается с 0
     */
    @GetMapping("/pageable")
    public List<User> findAllWithPageable(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return userRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    /**
     * Демонстрация работы метода findAll с поиском по примеру. В качестве примера используется обёртка вокруг «примера
     * объекта», где не-null поля используются как условия фильтрации
     */
    @GetMapping("/example")
    public List<User> findAllWithExample(@RequestParam String name, @RequestParam String middleName) {
        User user = new User();
        user.setUserName(name);
        user.setUserMiddleName(middleName);
        Example<User> userExample = Example.of(user);
        return userRepository.findAll(userExample);
    }

    /**
     * Демонстрация работы метода findAll с поиском по примеру и сортировкой. В качестве примера используется обёртка
     * вокруг «примера объекта», где не-null поля используются как условия фильтрации
     */
    @GetMapping("/example/sort")
    public List<User> findAllWithExampleAndSort(@RequestParam String name,
                                                @RequestParam String middleName,
                                                @RequestParam String field){
        User user = new User();
        user.setUserName(name);
        user.setUserMiddleName(middleName);
        Example<User> userExample = Example.of(user);
        return userRepository.findAll(userExample, Sort.by(Sort.Direction.DESC, field));
    }

    /**
     * Демонстрация работы метода findAll с поиском по примеру и пагинацией. В качестве примера используется обёртка
     * вокруг «примера объекта», где не-null поля используются как условия фильтрации
     */
    @GetMapping("/example/pageable")
    public List<User> findAllWithExampleAndPageable(@RequestParam String name,
                                                    @RequestParam String middleName,
                                                    @RequestParam Integer pageNumber,
                                                    @RequestParam Integer pageSize){
        User user = new User();
        user.setUserName(name);
        user.setUserMiddleName(middleName);
        Example<User> userExample = Example.of(user);
        return userRepository.findAll(userExample, PageRequest.of(pageNumber, pageSize)).getContent();
    }
}
