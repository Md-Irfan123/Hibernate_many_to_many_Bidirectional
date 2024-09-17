package com.jpa.Hibernate_Many_to_Many_Bidirectional.Controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.jpa.Hibernate_Many_to_Many_Bidirectional.dao.UserBankDao;
import com.jpa.Hibernate_Many_to_Many_Bidirectional.dto.Bank;
import com.jpa.Hibernate_Many_to_Many_Bidirectional.dto.User;

public class UserBankInsertController {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		UserBankDao dao=new UserBankDao();
		
		
	char p;
		
		do {
			System.out.println("Enter your option....");
			System.out.println("1.INSERT\n2.DELETE\n4.UPDATE\n5.DISPLAY\n6.DeleteByJPQL\n7.UpdateByJPQL");
			int key=sc.nextInt();
			switch(key) {
		case 1:{
		
		List<User> users=Arrays.asList(new User("Anupam", 48574985, 999999999, LocalDate.of(2024, 01, 31)),
				new User("Md Irfan", 958945894, 344594859, LocalDate.of(2002, 02, 20)));
		
		List<Bank> banks=Arrays.asList(new Bank(101, "Hdfc", "Noida", "hdfc123", 420,users),
				new Bank(102, "SBI", "Banglore", "sbi123", 786,users));
		
		dao.saveUserBankDao(users, banks);
		
		}
		break;
		case 2:{
			
			System.out.println("Enter id to delete");
			
			int id=sc.nextInt();
			
			User user=dao.deleteUserByIdDao(id);
			if(user!=null) {
				System.out.println("Deleted Successfully");
				
			}
			else {
				System.out.println("Id is not deleted");
			}	
			
		}
		break;
		
		case 3: {
			System.out.println("Enter User id to update User name");
			int id=sc.nextInt();
			System.out.println("Enter new User name");
			String name=sc.nextLine();
			name+=sc.nextLine();
			
			User user=dao.UpdateUserByIdDao(id, name);
			
			if(user!=null) {
				System.out.println("Data updated");
			}else {
				System.out.println("Id not found!......");
			}
		}
		break;
		
		case 4:{
			for (User user : dao.getAllUserAndBankDao()) {
				
				System.out.println(user);
				
			}
		}
			
			}System.out.println("Press Y/y to continue");
			p=sc.next().charAt(0);
			
			}while(p=='Y'|| p== 'y');
		System.out.println("Program ends");
		

	}

}
