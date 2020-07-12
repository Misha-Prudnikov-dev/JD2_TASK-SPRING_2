package by.htp.ishop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.htp.ishop.dao.DAOException;
import by.htp.ishop.dao.UserDAO;
import by.htp.ishop.entity.User;
import by.htp.ishop.service.ServiceException;
import by.htp.ishop.service.UserService;
import by.htp.ishop.service.validation.Validator;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public User signIn(String email, String password) throws ServiceException {

		if (!Validator.emailAndPasswordValid(email, password)) {

			throw new ServiceException("Wrong Data");
		}

		User user = null;
		try {
			user = userDAO.signIn(email, password);
		} catch (DAOException e) {

			throw new ServiceException(e);

		}

		return user;
	}

	@Override
	@Transactional
	public void registration(User user) throws ServiceException {

		if (!Validator.userRegistrationValid(user, user.getPassword())) {

			throw new ServiceException("Wrong Data");
		}

		try {
			userDAO.registration(user);
		} catch (DAOException e) {
			throw new ServiceException(e);

		}

	}

	@Override
	@Transactional
	public void changeUserData(User user) throws ServiceException {

		try {
			userDAO.changeUserData(user);
		} catch (DAOException e) {
			throw new ServiceException(e);

		}
	}

}
