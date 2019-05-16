package id.bts.userShoppingThymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import id.bts.userShoppingThymeleaf.domains.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
