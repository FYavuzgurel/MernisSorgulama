import business.concretes.UserManager;
import business.concretes.UserValidatorManager;
import core.GoogleManagerAdapter;
import core.IGoogleService;
import dataAcces.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {		
		
		User user1=new User(1, "fatih", "Gürel", "fatih@gmail.com", "123456");
		UserManager userManager = new UserManager(new HibernateUserDao(),new UserValidatorManager(new HibernateUserDao()),new GoogleManagerAdapter());
		userManager.singUp(user1);
		userManager.singIn(user1);		
	}
}
