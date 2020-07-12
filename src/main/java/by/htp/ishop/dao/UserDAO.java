package by.htp.ishop.dao;

import by.htp.ishop.entity.User;

public interface UserDAO {

	User signIn(String login, String password)throws DAOException;

	void registration(User user)throws DAOException;

	void quickRegistration(String email, String userPassword)throws DAOException;

	void changeUserData(User user)throws DAOException;

	void changeUserStatus(int id, String status)throws DAOException;

}
