package com.livares.intern.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livares.intern.Model.UserProductCart;
import com.livares.intern.Repository.UserProductCartRepository;

@Service
public class UserProductCartServiceImpl implements UserProductCartService {
	
	    @Autowired
	    private UserProductCartRepository userProductCartRepository;

	    public List<UserProductCart> getAllUserProductCarts() {
	        return userProductCartRepository.findAll();
	    }

	    public Optional<UserProductCart> getUserProductCartById(Long id) {
	        return userProductCartRepository.findById(id);
	    }

	    public UserProductCart saveUserProductCart(UserProductCart userProductCart) {
	        return userProductCartRepository.save(userProductCart);
	    }

	    public void deleteUserProductCart(Long id) {
	        userProductCartRepository.deleteById(id);
	    }
	   
	}


