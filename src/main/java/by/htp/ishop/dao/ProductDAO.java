package by.htp.ishop.dao;

import java.util.List;
import java.util.Map;

import by.htp.ishop.entity.Category;
import by.htp.ishop.entity.Manufacturer;
import by.htp.ishop.entity.Product;
import by.htp.ishop.entity.ProductDetail;
 import by.htp.ishop.entity.Subcategory;

public interface ProductDAO {

	 boolean changeProductTitle(Product product,String title)throws DAOException;
	
	 boolean changeProductPrice(Double price)throws DAOException;
	
	 boolean changeProductDescription(String description)throws DAOException;
	 
	 boolean addProduct(Product product)throws DAOException;
	 
	 void addImageProduct(Product product)throws DAOException;
	
	 List<Product> findByTitleProduct(String title) throws DAOException;
	 	
	 List<Product> findByParametrProduct(Map<String,String> param)throws DAOException;
	 
	 List<Product> findProductBySubcategory(int id) throws DAOException;

	 List<Subcategory> getSubcategory(int id) throws DAOException;
	 
	 Product getProductById(int id) throws DAOException;
	 
	 List<Category> getCategory() throws DAOException;

	 void deleteProduct(Product product)throws DAOException;
	 
	 void addProductToFavorites(int userId,int productId) throws DAOException;

	 void removeProductToFavorites(int userId,int productId) throws DAOException;

	 List<Product> getProductFavorites(int userId)throws DAOException;

}
