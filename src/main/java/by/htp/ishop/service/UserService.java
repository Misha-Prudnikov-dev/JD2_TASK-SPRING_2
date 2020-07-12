package by.htp.ishop.service;

import by.htp.ishop.dao.DAOException;
import by.htp.ishop.entity.User;

public interface UserService {

	User signIn(String email,String password)throws ServiceException;
	
	void registration(User user)throws ServiceException;
	
	void changeUserData(User user)throws ServiceException;

}
