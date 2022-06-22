package business.concretes;

import business.abstracts.IUserService;
import core.IGoogleService;
//import core.LoggerService;
import dataAcces.abstracts.IUserDao;
import entities.concretes.User;

public class UserManager implements IUserService{
	IUserDao userDao;
	UserValidatorManager userValidatorManager;
	private IGoogleService googleService;
	
	public UserManager(IUserDao userDao, UserValidatorManager userValidatorManager,IGoogleService googleService) {
		super();
		this.userDao = userDao;
		this.userValidatorManager = userValidatorManager;
		this.googleService=googleService;
	}

	@Override
	public void singUp(User user) { //kullanýcý kaydetme
		if (userValidatorManager.isValid(user) == true) {
			System.out.println("Kullanýcý baþarýyla sisteme eklendi ");	
			googleService.verifyToMail();
		}
		else {
			System.out.println("Kullanýcý sisteme eklenemedi ");
		}
	}
 
	@Override
	public void singIn(User user) { //sisteme giriþ
		if (userDao.getEmail()==user.getEmail()){
			if(userDao.getPassword()==user.getPassword()) {
				System.out.println("Kullanýcý giriþi yapýldý ");
			}		
		}
		else {
			System.out.println("Kullanýcý giriþi baþarýsýz !!");
		}
	}
}
