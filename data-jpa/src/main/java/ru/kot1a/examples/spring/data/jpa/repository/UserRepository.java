package ru.kot1a.examples.spring.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kot1a.examples.spring.data.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
