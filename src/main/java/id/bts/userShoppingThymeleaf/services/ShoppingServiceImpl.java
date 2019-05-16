package id.bts.userShoppingThymeleaf.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import id.bts.userShoppingThymeleaf.domains.Shopping;
import id.bts.userShoppingThymeleaf.repositories.ShoppingRepository;

@Service
public class ShoppingServiceImpl implements ShoppingService{

	@Autowired
	private ShoppingRepository shoppingRepository;

	@Override
	public Page<Shopping> getAllShopping(int page, int size) {
		
		return shoppingRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Shopping getShoppingById(Long id) {
		
		return shoppingRepository.findById(id).get();
	}

	@Override
	public Shopping saveShopping(Shopping shopping) {
		
		shopping.setCreateddate(LocalDate.now());
		
		return shoppingRepository.save(shopping);
	}

	@Override
	public void deleteShopping(Long id) {
		
		Shopping shopping = shoppingRepository.findById(id).get();
		
		shoppingRepository.delete(shopping);
	}
	
	
}
