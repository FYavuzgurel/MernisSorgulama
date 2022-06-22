package business.abstracts;

import entities.concretes.User;

public interface IUserValidatorService {
		boolean emailValid(User user);
		boolean uniqueEmail (User user);
		boolean firsNameValid(User user);
		boolean lastNameValid(User user);
		boolean passwordValid(User user);
		boolean isValid(User user);
}
