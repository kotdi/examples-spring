package ru.katesh.examples.spring.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.katesh.examples.spring.data.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
