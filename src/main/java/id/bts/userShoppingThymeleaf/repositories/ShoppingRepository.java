package id.bts.userShoppingThymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import id.bts.userShoppingThymeleaf.domains.Shopping;

public interface ShoppingRepository extends JpaRepository<Shopping, Long>{

}
