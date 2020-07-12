package by.htp.ishop.service.validation;

import java.util.regex.Pattern;

import by.htp.ishop.entity.User;
import by.htp.ishop.service.ServiceException;

public class Validator {

	private static final String regexEmail = "([.[^@\\s]]+)@([.[^@\\s]]+)\\.([a-z]+)";
	private static final String regexEmail2 = "/^.+@.+\\..+$/";

	private static final String regexPassword = "( (?=.*[*#$]) ([0-9]|[a-z]) {5,15} ([0-9]|[*#$]) {1,5} )";

	public static boolean emailAndPasswordValid(String email, String password) throws ServiceException {

		if (email == null || email.isEmpty()) {

			throw new ServiceException("Incorrect email");
		}
		if (password == null || password.isEmpty()) {

			throw new ServiceException("Incorrect password");
		}

		/*
		 * if (!(Pattern.matches(regexEmail2, email))) {
		 * 
		 * return false;
		 * 
		 * } /* if (!(Pattern.matches(regexPassword, password))) {
		 * 
		 * return false;
		 * 
		 * }
		 */

		return true;

	}

	public static boolean userRegistrationValid(User user, String password) throws ServiceException {

		if (user.getEmail() == null || user.getEmail().isEmpty() || user.getLogin() == null || user.getLogin().isEmpty()
				|| user.getName() == null || user.getName().isEmpty() || user.getSurname() == null
				|| user.getSurname().isEmpty() || user.getPhone() == null || user.getPhone().isEmpty()) {

			throw new ServiceException("Incorrect data");

		}
		if (password == null || password.isEmpty()) {
			throw new ServiceException("Incorrect password");

		}

		return true;

	}
	public static boolean userUpdateValid(User user) throws ServiceException {

		if (user.getLogin() == null || user.getLogin().isEmpty()
				|| user.getName() == null || user.getName().isEmpty() || user.getSurname() == null
				|| user.getSurname().isEmpty() || user.getPhone() == null || user.getPhone().isEmpty()) {

			throw new ServiceException("Incorrect data");

		}
		

		return true;

	}
}
