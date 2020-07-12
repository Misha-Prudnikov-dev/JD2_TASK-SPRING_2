package by.htp.ishop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.htp.ishop.dao.DAOException;
import by.htp.ishop.dao.ProductDAO;
import by.htp.ishop.entity.Category;
import by.htp.ishop.entity.Product;
import by.htp.ishop.entity.Subcategory;
import by.htp.ishop.service.ProductService;
import by.htp.ishop.service.ServiceException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	@Transactional
	public List<Product> findProductBySubcategory(int id) throws ServiceException {

		List<Product> getGroupProduct;

		try {
			getGroupProduct = productDAO.findProductBySubcategory(id);

		} catch (DAOException e) {

			throw new ServiceException(e);

		}

		return getGroupProduct;
	}

	@Override
	@Transactional
	public List<Subcategory> getSubcategory(int id) throws ServiceException {

		List<Subcategory> getGroupSubcategory;

		try {
			getGroupSubcategory = productDAO.getSubcategory(id);

		} catch (DAOException e) {

			throw new ServiceException(e);

		}

		return getGroupSubcategory;
	}

	@Override
	@Transactional
	public Product getProductById(int id) throws ServiceException {

		Product product;

		try {
			product = productDAO.getProductById(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return product;
	}

	@Override
	@Transactional
	public List<Category> getCategory() throws ServiceException {

		List<Category> getGroupCategory;

		try {
			getGroupCategory = productDAO.getCategory();

		} catch (DAOException e) {

			throw new ServiceException(e);

		}

		return getGroupCategory;
	}

	@Override
	@Transactional
	public void addProductToFavorites(int userId, int productId) throws ServiceException {

		try {
			productDAO.addProductToFavorites(userId, productId);

		} catch (DAOException e) {
			throw new ServiceException(e);

		}
	}

	@Override
	@Transactional
	public void removeProductToFavorites(int userId, int productId) throws ServiceException {

		try {
			productDAO.removeProductToFavorites(userId, productId);

		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	@Transactional
	public List<Product> getProductFavorites(int userId) throws ServiceException {

		List<Product> getGroupProductFavorites;

		try {

			getGroupProductFavorites = productDAO.getProductFavorites(userId);

		} catch (DAOException e) {
			throw new ServiceException(e);

		}

		return getGroupProductFavorites;
	}

}
