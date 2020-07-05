package application;

import java.util.List;

import javax.swing.JOptionPane;

import dao.DaoFactory;
import dao.SellerDao;
import entities.Department;
import entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerdao = DaoFactory.createSellerDao();
		
		//Seller seller = sellerdao.findById(Integer.parseInt(JOptionPane.showInputDialog("Qual ID deseja buscar?")));
		//System.out.println(seller);
		
		Department dep = new Department(Integer.parseInt(JOptionPane.showInputDialog("Insira o ID: " )), null);
		List<Seller> list = sellerdao.findByDepartment(dep);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		
		System.out.println("--------------------------------------------");
		list = sellerdao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}

	}

}
