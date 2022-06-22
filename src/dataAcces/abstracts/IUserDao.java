package dataAcces.abstracts;

import entities.concretes.User;

public interface IUserDao {
	void DbAdd(User user);
	void DbDelete(User user);
	void DbUpdate(User user);
	void setEmail(String email);
	void setPassword(String email);
	String getEmail();
	String getPassword();
}
