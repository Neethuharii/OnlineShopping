package com.livares.intern.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.livares.intern.model.Product;
import com.livares.intern.model.User;
import com.livares.intern.model.UserProductCart;
import com.livares.intern.repository.ProductRepository;
import com.livares.intern.repository.UserProductCartRepository;
import com.livares.intern.service.UserProductCartService;

@Service
public class UserProductCartServiceImpl implements UserProductCartService {

	@Autowired
	private UserProductCartRepository userProductCartRepository;

	@Autowired
	ProductRepository productRepo;

	@Override
	/**=====================================================
	 * 
	 *  adding a product to the user's cart in the database.
	 *  
	 =========================================================*/
	public ResponseEntity<Object> addToCart(Long userId, Long productId) {
        User user = new User();
        user.setId(userId);

        Product product = new Product();
        product.setId(productId);

        UserProductCart userProductCart = new UserProductCart();
        userProductCart.setUser(user);
        userProductCart.setProduct(product);

        userProductCartRepository.save(userProductCart);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
	
  /**==============================================================
     * retrieving the products in the user's cart from the database.
   ==================================================================*/
	 public ResponseEntity<List<Product>> viewCart(Long userId) {
	        List<Product> products = productRepo.findByUser(userId);
	        if (!products.isEmpty()) {
	            return ResponseEntity.ok(products);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }
	    }

	/**-============================================================
	 *  removing a product from the user's cart in the database.
	 ==============================================================*/
	  public ResponseEntity<Object> removeFromCart(Long productId) {
	        try {
	            userProductCartRepository.removeById(productId);
	            return ResponseEntity.ok("Product removed from cart successfully");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to remove product from cart");
	        }
	    }
	@Override
	public void deleteUserProductCart(Long id) {
		
	}
}
