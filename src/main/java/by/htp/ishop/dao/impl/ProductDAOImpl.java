package by.htp.ishop.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.htp.ishop.dao.DAOException;
import by.htp.ishop.dao.ProductDAO;
import by.htp.ishop.entity.Category;
import by.htp.ishop.entity.Manufacturer;
import by.htp.ishop.entity.Product;
import by.htp.ishop.entity.ProductDetail;
import by.htp.ishop.entity.ProductImage;
import by.htp.ishop.entity.Subcategory;
import by.htp.ishop.entity.User;

@Repository
public class ProductDAOImpl implements ProductDAO {

	private static final String SUBCATEGORY_ID = "subcategoryId";
	private static final String CATEGORY_ID = "categoryId";

	private static final String GROUP_PRODUCT_BY_SUBCATEGORY = "from Product where subcategories_id_subcategories = :subcategoryId";
	private static final String GET_ALL_SUBCATEGORY = "from Subcategory where categories_id_categories = :categoryId";
	private static final String GET_ALL_CATEGORY = "from Category";

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean changeProductTitle(Product product, String title) {

		return false;
	}

	@Override
	public boolean changeProductPrice(Double price) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeProductDescription(String description) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> findByTitleProduct(String title) throws DAOException {
		return null;
	}

	@Override
	public List<Product> findByParametrProduct(Map<String, String> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> findProductBySubcategory(int subcategoryId) throws DAOException {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Product> theQuery = currentSession.createQuery(GROUP_PRODUCT_BY_SUBCATEGORY, Product.class);

		List<Product> products = theQuery.setParameter(SUBCATEGORY_ID, subcategoryId).getResultList();

		return products;
	}

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addImageProduct(Product product) throws DAOException {

	}

	@Override
	public List<Subcategory> getSubcategory(int categoryId) throws DAOException {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Subcategory> theQuery = currentSession.createQuery(GET_ALL_SUBCATEGORY, Subcategory.class);

		List<Subcategory> subcategories = theQuery.setParameter(CATEGORY_ID, categoryId).getResultList();

		return subcategories;

	}

	@Override
	public Product getProductById(int id) throws DAOException {

		Session currentSession = sessionFactory.getCurrentSession();

		Product product = currentSession.get(Product.class, id);

		return product;
	}

	@Override
	public List<Category> getCategory() throws DAOException {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Category> theQuery = currentSession.createQuery(GET_ALL_CATEGORY, Category.class);

		List<Category> categories = theQuery.getResultList();

		return categories;
	}

	@Override
	public void addProductToFavorites(int userId, int productId) throws DAOException {

	}

	@Override
	public List<Product> getProductFavorites(int userId) throws DAOException {

		return null;

	}

	@Override
	public void removeProductToFavorites(int userId, int productId) throws DAOException {

	}

}
