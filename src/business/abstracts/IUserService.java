package business.abstracts;

import entities.concretes.User;

public interface IUserService {
	void singUp(User user);
	void singIn(User user);
}
