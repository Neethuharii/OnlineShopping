package com.livares.intern.Service;

import java.util.List;
import java.util.Optional;

import com.livares.intern.Model.UserProductCart;

public interface UserProductCartService {
	
	public List<UserProductCart> getAllUserProductCarts() ;
       

    public Optional<UserProductCart> getUserProductCartById(Long id); 

    public UserProductCart saveUserProductCart(UserProductCart userProductCart);

    public void deleteUserProductCart(Long id);
    public void addToCart(Long userId,Long productId);

}
