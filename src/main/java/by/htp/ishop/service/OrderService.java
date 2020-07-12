package by.htp.ishop.service;

import java.util.List;

import by.htp.ishop.dao.DAOException;
import by.htp.ishop.entity.Basket;
import by.htp.ishop.entity.OrderDetail;
import by.htp.ishop.entity.Product;
import by.htp.ishop.entity.User;

public interface OrderService {

	void createOrder(int userId) throws ServiceException;

	void addProductToOrder(int orderId, int productId, int quantityProduct) throws ServiceException;

	List<OrderDetail> getProductInOrder(int orderId) throws ServiceException;

	void removeProductFromOrder(int productId, int orderId) throws ServiceException;

	int getOrderId(int userId) throws ServiceException;


}
