package by.htp.ishop.dao;

import java.util.List;

 import by.htp.ishop.entity.Basket;
import by.htp.ishop.entity.Order;
import by.htp.ishop.entity.OrderDetail;
import by.htp.ishop.entity.Product;
import by.htp.ishop.entity.User;

public interface OrderDAO {
	
	void createOrder(int userId)throws DAOException;
	
	void addProductToOrder(int orderId,int productId,int quantityProduct)throws DAOException;
	
	
	List<OrderDetail>  getProductInOrder(int orderId)throws DAOException;
	 
	int getOrderId(int userId)throws DAOException;
	
	void removeProductFromOrder(int productId, int orderId)throws DAOException;
	

 	
	
}
