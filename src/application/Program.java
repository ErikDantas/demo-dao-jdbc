package application;

import java.util.Date;

import dao.DaoFactory;
import dao.SellerDao;
import entities.Department;
import entities.Seller;

public class Program {

	public static void main(String[] args) {

		Department obj = new Department(1,"Electronics");
		Seller seller = new Seller(12, "Bob","bob@gmail.com",new Date(),2400,obj);
		System.out.println(seller);
		
		SellerDao sellerdao = DaoFactory.createSellerDao();
		
	}

}
