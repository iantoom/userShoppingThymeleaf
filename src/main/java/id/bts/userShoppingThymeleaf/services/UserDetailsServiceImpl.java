package id.bts.userShoppingThymeleaf.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import id.bts.userShoppingThymeleaf.domains.User;
import id.bts.userShoppingThymeleaf.domains.UserDetails;
import id.bts.userShoppingThymeleaf.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByEmailIgnoreCase(username);

		log.debug(user.getEmail());

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
		grantList.add(authority);

		return new UserDetails(user.getEmail(), user.getPassword(), grantList);
	}

}
