package sbs.rosedev.springFirst.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sbs.rosedev.springFirst.entity.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByEmail(String email);
    Optional<UserAccount> findByUsername(String username);
}
