package by.htp.ishop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.htp.ishop.dao.OrderDAO;
import by.htp.ishop.dao.DAOException;
import by.htp.ishop.dao.ProductDAO;
import by.htp.ishop.entity.Basket;
import by.htp.ishop.entity.Order;
import by.htp.ishop.entity.OrderDetail;
import by.htp.ishop.entity.Product;
import by.htp.ishop.entity.ProductImage;
import by.htp.ishop.entity.User;

@Repository
public class OrderDAOImpl implements OrderDAO {

	private static final String ORDER_ID = "orderId";
	private static final String USER_ID_P = "userId";
	private static final String PRODUCT_ID = "productId";

	private static final String STATUS_ORDER_CART = "CART";
	private static final String STATUS_ORDER_ORDER = "ORDER";
	private static final String STATUS_ORDER_BOUGHT = "BOUGHT";

	private static final String GET_PRODUCT_IN_ORDER = " from OrderDetail where order.id = :orderId";
	private static final String GET_ORDER_ID = "from Order where user.id = :userId";
	private static final String DELETE_PRODUCT_IN_ORDER_DETAIL = "delete  from OrderDetail where product.id = :productId and order.id = :orderId";

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createOrder(int userId) throws DAOException {

		Session currentSession = sessionFactory.getCurrentSession();

		User user = currentSession.get(User.class, userId);

		Order order = new Order();

		order.setStatus(STATUS_ORDER_CART);
		order.setUser(user);

		currentSession.save(order);

	}

	@Override
	public void addProductToOrder(int orderId, int productId, int quantityProduct) throws DAOException {

		Session currentSession = sessionFactory.getCurrentSession();

		OrderDetail orderDetail = new OrderDetail();

		Order order = currentSession.get(Order.class, orderId);
		Product product = currentSession.get(Product.class, productId);

		orderDetail.setOrder(order);
		orderDetail.setProduct(product);
		orderDetail.setQuantity(quantityProduct);

		currentSession.save(orderDetail);
	}

	@Override
	public void removeProductFromOrder(int productId, int orderId) throws DAOException {

		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery(DELETE_PRODUCT_IN_ORDER_DETAIL).setParameter(PRODUCT_ID, productId)
				.setParameter(ORDER_ID, orderId);

		theQuery.executeUpdate();
	}

	@Override
	public List<OrderDetail> getProductInOrder(int orderId) throws DAOException {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<OrderDetail> theQuery = currentSession.createQuery(GET_PRODUCT_IN_ORDER, OrderDetail.class);

		List<OrderDetail> orderDetails = theQuery.setParameter(ORDER_ID, orderId).getResultList();

		return orderDetails;

	}

	@Override
	public int getOrderId(int userId) throws DAOException {

		Session currentSession = sessionFactory.getCurrentSession();

		Order order = (Order) currentSession.createQuery(GET_ORDER_ID, Order.class).setParameter(USER_ID_P, userId)
				.getSingleResult();

		return order.getId();

	}

}
