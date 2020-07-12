package by.htp.ishop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.htp.ishop.dao.OrderDAO;
import by.htp.ishop.entity.Basket;
import by.htp.ishop.entity.OrderDetail;
import by.htp.ishop.entity.Product;
import by.htp.ishop.entity.User;
import by.htp.ishop.dao.DAOException;
import by.htp.ishop.service.OrderService;
import by.htp.ishop.service.ServiceException;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Override
	@Transactional
	public void createOrder(int userId) throws ServiceException {

		try {

			orderDAO.createOrder(userId);

		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	@Transactional
	public void addProductToOrder(int orderId, int productId, int quantityProduct) throws ServiceException {

		try {

			orderDAO.addProductToOrder(orderId, productId, quantityProduct);

		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	@Transactional
	public List<OrderDetail> getProductInOrder(int orderId) throws ServiceException {

		List<OrderDetail> groupOrderDetail = null;

		try {

			groupOrderDetail = orderDAO.getProductInOrder(orderId);

			return groupOrderDetail;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	@Transactional
	public void removeProductFromOrder(int productId, int orderId) throws ServiceException {

		try {
			orderDAO.removeProductFromOrder(productId, orderId);
		} catch (DAOException e) {
			throw new ServiceException(e);

		}

	}

	@Override
	@Transactional
	public int getOrderId(int userId) throws ServiceException {

		try {
			return orderDAO.getOrderId(userId);
		} catch (DAOException e) {
			throw new ServiceException(e);

		}

	}

}
