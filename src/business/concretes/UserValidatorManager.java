package business.concretes;

import java.util.regex.Pattern;

import business.abstracts.IUserValidatorService;
import dataAcces.abstracts.IUserDao;
import entities.concretes.User;

public class UserValidatorManager implements IUserValidatorService{

	IUserDao iUserDao;

	public UserValidatorManager(IUserDao iUserDao) {
		super();
		this.iUserDao = iUserDao;
	}

	@Override
	public boolean uniqueEmail(User user) {
		String regex = "^[A-Z0-9._%+-]+[A-Z0-9]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.A-Z{2,})?$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

		if (user.getEmail().isEmpty()) {
			System.out.println(" Email bo� b�rakmay�n�z");
			return false;

		} else if (pattern.matcher(user.getEmail()).find()) {
			System.out.println("e mail format�nda olmal�");
			return false;
		}
		return true; 
	}

	@Override
	public boolean firsNameValid(User user) {
		if(user.getFirstName().isEmpty()) {
			System.out.println("Kullan�c� ismi bo� olamaz !!");
			return false; 
		}
		else if(user.getFirstName().length()<2) {
			System.out.println("Kullan�c� ismi iki karakterden az olamaz !!");
			return false; 
		}
		else {
			System.out.println("Kullan�c� ismi olu�turuldu");
			return true; 
		}
	}

	@Override
	public boolean lastNameValid(User user) {
		if(user.getFirstName().isEmpty()) {
			System.out.println("Kullan�c� soyad� bo� olamaz !!");
			return false; 
		}
		else if(user.getFirstName().length()<2) {
			System.out.println("Kullan�c� soyismi iki karakterden az olamaz !!");
			return false; 
		}
		else {
			System.out.println("Kullan�c� soyismi olu�turuldu");
			return true; 
		}
	}
	@Override
	public boolean emailValid(User user) {
		if (iUserDao.getEmail()== user.getEmail()) {
			System.out.println("Bu Email daha �nce kullan�lm��t�r");
			return false;
		}
		else {
			return true; 
		}
	}

	@Override
	public boolean passwordValid(User user) { 
		if(user.getPassword().isEmpty()) {
			System.out.println("Bu alan bo� b�rak�lamaz !!");
			return false;
		}
		else if (user.getPassword().length()<6) {
			System.out.println("�ifre 6 karakterden az olamaz !!");
			return false;
	}
		else {
			System.out.println("Parola olu�turuldu");
			return true;
		}
	}
	
	@Override
	public boolean isValid(User user) { 
		if(firsNameValid(user)&&lastNameValid(user)&&emailValid(user)&& uniqueEmail(user)&&  passwordValid(user)==true) {
			return true;
		}
		return false;
	}	
}
