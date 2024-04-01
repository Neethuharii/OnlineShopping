package com.livares.intern.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.livares.intern.Model.UserProductCart;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userProductCarts")
public class UserProductCartController {

    @Autowired
    private UserProductCartController userProductCartService;

    @GetMapping("/getAllProduct")
    public List<UserProductCart> getAllUserProductCarts() {
        return userProductCartService.getAllUserProductCarts();
    }

    @GetMapping("/getProductById/{id}")
    public Optional<UserProductCart> getUserProductCartById(@PathVariable Long id) {
        return userProductCartService.getUserProductCartById(id);
    }

    @PostMapping("/update")
    public UserProductCart saveUserProductCart(UserProductCart userProductCart) {
        return userProductCartService.saveUserProductCart(userProductCart);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteUserProductCart(@PathVariable Long id) {
        userProductCartService.deleteUserProductCart(id);
    }
}
