package com.jpa.Hibernate_Many_to_Many_Bidirectional.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jpa.Hibernate_Many_to_Many_Bidirectional.dto.Bank;
import com.jpa.Hibernate_Many_to_Many_Bidirectional.dto.User;



public class UserBankDao {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public List<User> saveUserBankDao(List<User> users,List<Bank> banks){
		et.begin();
		for (Bank bank : banks) {
			em.persist(bank);
			
		}
//		for (User user : users) {
//			em.persist(user);
//			
//		}
		
		et.commit();
		return users;
		
		
	}
	public  User deleteUserByIdDao(int userId) {
		
		String deletedUserQuery= "delete from bank_user where users_id=?";
		Query query=em.createNativeQuery(deletedUserQuery);
		query.setParameter(1, userId);
		User user=em.find(User.class, userId);
		if(user!=null) {
			et.begin();
			query.executeUpdate();
			
			em.remove(user);
			et.commit();
			return user;
		}else {
			return null;
		}
		
	}
	public User UpdateUserByIdDao(int userId,String name) {
		User user=em.find(User.class, userId);
		if(user!=null) {
			user.setName(name);
			et.begin();
			em.merge(user);
			et.commit();
			
			return user;
			}else {
				return null;
			}
		}
		
	
	public List<User> getAllUserAndBankDao()
	{
		String selectQuery="select u  From User u";
		Query query=em.createQuery(selectQuery);
		return query.getResultList();
	}
	public User getAllBankByUserId(int userId) {
		return em.find(User.class,userId);
	}

}
	
	

