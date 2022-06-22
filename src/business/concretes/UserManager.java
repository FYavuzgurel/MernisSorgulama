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
	public void singUp(User user) { //kullan�c� kaydetme
		if (userValidatorManager.isValid(user) == true) {
			System.out.println("Kullan�c� ba�ar�yla sisteme eklendi ");	
			googleService.verifyToMail();
		}
		else {
			System.out.println("Kullan�c� sisteme eklenemedi ");
		}
	}
 
	@Override
	public void singIn(User user) { //sisteme giri�
		if (userDao.getEmail()==user.getEmail()){
			if(userDao.getPassword()==user.getPassword()) {
				System.out.println("Kullan�c� giri�i yap�ld� ");
			}		
		}
		else {
			System.out.println("Kullan�c� giri�i ba�ar�s�z !!");
		}
	}
}
