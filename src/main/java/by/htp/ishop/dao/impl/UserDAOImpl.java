package by.htp.ishop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.htp.ishop.dao.DAOException;
import by.htp.ishop.dao.UserDAO;
import by.htp.ishop.entity.Role;
import by.htp.ishop.entity.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final String PASSWORD = "passwordUser";
	private static final String EMAIL = "emailUser";

	private static final String SELECT_Email_AND_PASSWORD = "from User where email = :emailUser  and   password = :passwordUser";

	@Autowired
	private SessionFactory sessionFactory;

	public User signIn(String userEmail, String userPassword) throws DAOException {

		Session currentSession = sessionFactory.getCurrentSession();

		User user = (User) currentSession.createQuery(SELECT_Email_AND_PASSWORD, User.class)
				.setParameter(EMAIL, userEmail).setParameter(PASSWORD, userPassword).list().get(0);

		return user;

	}

	public void registration(User user) throws DAOException {

		Session currentSession = sessionFactory.getCurrentSession();

		Role role = currentSession.get(Role.class, 1);

		user.setRole(role);

		currentSession.save(user);

	}

	@Override
	public void quickRegistration(String userEmail, String userPassword) throws DAOException {

	}

	@Override
	public void changeUserStatus(int id, String status) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeUserData(User user) throws DAOException {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.update(user);

	}

}
