package by.htp.ishop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.ishop.dao.ProductDAO;
import by.htp.ishop.dao.impl.ProductDAOImpl;
import by.htp.ishop.entity.OrderDetail;
import by.htp.ishop.entity.User;
import by.htp.ishop.service.OrderService;
import by.htp.ishop.service.ProductService;
import by.htp.ishop.service.ServiceException;
import by.htp.ishop.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.apache.log4j.Logger;

@Controller
@RequestMapping("/")
public class MainController {

	private static final String USER = "user";
	private static final String ORDER_ID = "id_order";
	private static final String GROUP_PRODUCT_IN_CART = "groupProductCart";
	private static final String GROUP_PRODUCT = "groupProduct";
	private static final String SUBCATEGORY_ID = "subcategory";
	private static final String CATEGORY_ID = "categoryId";
	private static final String GROUP_SUBCATEGORY = "groupSubcategory";
	private static final String PRODUCT_ID = "productId";
	private static final String PRODUCT_INFO = "productInfo";
	private static final String GROUP_CATEGORY = "groupCategory";
	private static final String QUANTITY_PRODUCT = "quantityProduct";

	private UserService userService;
	private ProductService productService;
	private OrderService orderService;

	private static final Logger logger = Logger.getLogger(ProductDAOImpl.class);

	@Autowired
	public MainController(UserService userService, ProductService productService, OrderService orderService) {

		this.userService = userService;
		this.productService = productService;
		this.orderService = orderService;
	}

	@RequestMapping("/showMainPage")
	public String showMainPage(HttpSession session) {

		if (session.getAttribute(GROUP_CATEGORY) == null) {

			try {
				session.setAttribute(GROUP_CATEGORY, productService.getCategory());
			} catch (ServiceException e) {
				logger.error("Error showMainPage");

				throw new ControllerRuntimeException(e);
			}
		}

		return "main_page";
	}

	@RequestMapping("/showCartPage")
	public String showCartPage(HttpSession session, Model theModel) {

		if (session.getAttribute(USER) == null) {

			return "redirect:/showSignIn";
		}

		User user = (User) session.getAttribute(USER);

		try {

			int orderId = orderService.getOrderId(user.getId());

			session.setAttribute(ORDER_ID, orderId);

			List<OrderDetail> orderDetails = orderService.getProductInOrder(orderId);

			session.setAttribute(GROUP_PRODUCT_IN_CART, orderDetails);

		} catch (ServiceException e) {

			logger.error("Error showCartPage");

			throw new ControllerRuntimeException(e);
		}

		return "Cart";
	}

	@RequestMapping("/deleteProductFromCart")
	public String deleteProductFromCart(@RequestParam(PRODUCT_ID) int idProduct, HttpSession session) {

		try {

			orderService.removeProductFromOrder(idProduct, (int) session.getAttribute(ORDER_ID));
		} catch (ServiceException e) {
			logger.error("Error delete product from cart");

			throw new ControllerRuntimeException(e);
		}

		return "redirect:/showCartPage";
	}

	@RequestMapping("/showSignIn")
	public String showSignIn(Model theModel) {

		User user = new User();

		theModel.addAttribute(USER, user);

		return "SignIn";

	}

	@RequestMapping("/SignIn")
	public String signIn(@ModelAttribute("user") User user, Model theModel, HttpSession session) {

		// User user = null;
		try {
			user = userService.signIn(user.getEmail(), user.getPassword());
		} catch (ServiceException e) {
			logger.error("Error Sign In");

			throw new ControllerRuntimeException(e);
		}

		session.setAttribute(USER, user);

		return "redirect:/showMainPage";
	}

	@RequestMapping("/SignOut")
	public String signOut(@ModelAttribute("user") User user, Model theModel, HttpSession session) {

		session.removeAttribute(USER);

		return "redirect:/showMainPage";
	}

	@RequestMapping("/showRegistration")
	public String showRegistration(Model theModel) {

		User user = new User();

		theModel.addAttribute(USER, user);

		return "Registration";
	}

	@RequestMapping("/registration")
	public String registration(@ModelAttribute(USER) User user) {

		try {
			userService.registration(user);
		} catch (ServiceException e) {
			logger.error("Error registration");

			throw new ControllerRuntimeException(e);
		}

		return "redirect:/showMainPage";

	}

	@RequestMapping("/subcategory")
	public String subcategory(@RequestParam(CATEGORY_ID) int id, HttpSession session) {

		try {
			session.setAttribute(GROUP_SUBCATEGORY, productService.getSubcategory(id));
		} catch (ServiceException e) {
			logger.error("Error show subcategory");

			throw new ControllerRuntimeException(e);
		}

		return "Subcategory";
	}

	@RequestMapping("/groupProductBySubcategory")
	public String groupProductBySubcategory(@RequestParam(SUBCATEGORY_ID) int id, HttpSession session) {

		try {
			session.setAttribute(GROUP_PRODUCT, productService.findProductBySubcategory(id));
		} catch (ServiceException e) {
			logger.error("Error show group product by subcategory");

			throw new ControllerRuntimeException(e);
		}

		return "GroupProduct";
	}

	@RequestMapping("/showProductInfo")
	public String showProductInfo(@RequestParam(PRODUCT_ID) int id, HttpSession session) {

		try {
			session.setAttribute(PRODUCT_INFO, productService.getProductById(id));
		} catch (ServiceException e) {
			logger.error("Error show product info");

			throw new ControllerRuntimeException(e);
		}

		return "ProductInfo";
	}

	@RequestMapping("/showUserInfo")
	public String showUserInfo(HttpSession session, Model theModel) {

		User user = (User) session.getAttribute(USER);

		theModel.addAttribute(USER, user);

		return "UserInfo";
	}

	@RequestMapping("/updateUser")
	public String updateUser(@ModelAttribute(USER) User user) {

		try {
			userService.changeUserData(user);
		} catch (ServiceException e) {
			logger.error("Error update user");

			throw new ControllerRuntimeException(e);
		}

		return "redirect:/showUserInfo";
	}

	@RequestMapping("/addToCart")
	public String addToCart(@RequestParam(PRODUCT_ID) int idProduct,
			@RequestParam(QUANTITY_PRODUCT) int quantityProduct, HttpSession session) {

		try {
			orderService.addProductToOrder((int) session.getAttribute(ORDER_ID), idProduct, quantityProduct);
		} catch (ServiceException e) {
			logger.error("Error add to cart ");

			throw new ControllerRuntimeException(e);
		}

		return "redirect:/showMainPage";
	}

}
