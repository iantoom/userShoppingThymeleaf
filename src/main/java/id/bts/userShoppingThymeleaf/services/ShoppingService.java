package id.bts.userShoppingThymeleaf.services;

import org.springframework.data.domain.Page;

import id.bts.userShoppingThymeleaf.domains.Shopping;

public interface ShoppingService {

	Page<Shopping> getAllShopping(int page, int size);
	
	Shopping getShoppingById(Long id);
	
	Shopping saveShopping(Shopping shopping);
	
	void deleteShopping(Long id);
}
