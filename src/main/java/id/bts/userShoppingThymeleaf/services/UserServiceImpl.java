package id.bts.userShoppingThymeleaf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import id.bts.userShoppingThymeleaf.domains.User;
import id.bts.userShoppingThymeleaf.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	public Page<User> getAllUser(int page, int size){
		
		return userRepository.findAll(PageRequest.of(page, size));
	}
	
	public User saveUser(User user) {
		
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		User encryptedUser = user;
		return userRepository.save(encryptedUser);
	}
	
}
