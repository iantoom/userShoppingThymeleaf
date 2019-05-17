package id.bts.userShoppingThymeleaf.services;

import org.springframework.data.domain.Page;

import id.bts.userShoppingThymeleaf.domains.User;

public interface UserService {

	Page<User> getAllUser(int page, int size);
	
	User saveUser(User user);
}
