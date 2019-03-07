package com.bookstore.controller;


import com.bookstore.domain.Book;
import com.bookstore.domain.CartItem;
import com.bookstore.domain.ShoppingCart;
import com.bookstore.domain.User;
import com.bookstore.service.BookService;
import com.bookstore.service.CartItemService;
import com.bookstore.service.ShoppingCartService;
import com.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

/**
 * The type Shopping cart controller.
 */
@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

	@Autowired
	private UserService userService;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private ShoppingCartService shoppingCartService;

	@Autowired
	private BookService bookService;

	/**
	 * Cart string.
	 *
	 * @param model     the model
	 * @param principal the principal
	 * @return the string
	 */
	@RequestMapping("/cart")
	public String cart(Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		ShoppingCart shoppingCart = user.getShoppingCart();

		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

		shoppingCartService.updateShoppingCart(shoppingCart);

		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("shoppingCart", shoppingCart);

		return "shoppingCart";
	}

	/**
	 * Add item string.
	 *
	 * @param book      the book
	 * @param qty       the qty
	 * @param model     the model
	 * @param principal the principal
	 * @return the string
	 */
	@RequestMapping("/addItem")
	public String addItem(@ModelAttribute("book") Book book, @ModelAttribute("qty") String qty, Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		book = bookService.findOne(book.getId());

		if (Integer.parseInt(qty) > book.getInStockNumber()) {
			model.addAttribute("notEnoughStock", true);
			return "forward:/bookDetail?id=" + book.getId();
		}

		CartItem cartItem = cartItemService.addBookToCartItem(book, user, Integer.parseInt(qty));
		model.addAttribute("addBookSuccess", toString());

		return "forward:/bookDetail?id=" + book.getId();

	}

}
