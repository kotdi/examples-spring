package ru.katesh.examples.spring.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.katesh.examples.spring.hibernate.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
