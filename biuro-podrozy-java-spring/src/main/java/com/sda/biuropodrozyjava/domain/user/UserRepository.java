package com.sda.biuropodrozyjava.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByFirstNameLikeAndAndLastNameLike(String firstName, String lastName);

    User getByLogin(String login);
}
