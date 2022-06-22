package dataAcces.concretes;

import dataAcces.abstracts.IUserDao;
import entities.concretes.User;

public class HibernateUserDao implements IUserDao{

	
	@Override
	public void DbAdd(User user) {
		System.out.println("Hibernate ile eklendi : " + user.getFirstName());	
	}

	@Override
	public void DbDelete(User user) {
		System.out.println("Hibernate ile silindi : " + user.getFirstName());
	}

	@Override 
	public void DbUpdate(User user) {
		System.out.println("Hibernate g�ncellendi : " + user.getFirstName());
	}

	@Override
	public void setEmail(String email) {	
		
	}

	@Override
	public void setPassword(String email) {
		
	} 

	@Override
	public String getEmail() { // Veritaban�ndan okuma simulasyonu
		return "Fatih@gmail.com";
	
	}

	@Override
	public String getPassword() { // Veritaban�ndan okuma simulasyonu
		return "123456";
	}
	
}
