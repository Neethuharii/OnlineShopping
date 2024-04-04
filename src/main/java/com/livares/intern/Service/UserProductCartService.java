package com.livares.intern.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.livares.intern.Model.Product;
import com.livares.intern.Model.UserProductCart;

public interface UserProductCartService {
	
//	public List<UserProductCart> getAllUserProductCarts() ;
//       
//
//    public Optional<UserProductCart> getUserProductCartById(Long id); 
//
//    public UserProductCart saveUserProductCart(UserProductCart userProductCart);

    public void deleteUserProductCart(Long id);
    public ResponseEntity<Object> addToCart(Long userId, Long productId);

    public ResponseEntity<List<Product>> viewCart(Long userId) ;
    public ResponseEntity<Object> removeFromCart(Long productId);
}
