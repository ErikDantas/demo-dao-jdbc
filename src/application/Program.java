package application;

import javax.swing.JOptionPane;

import dao.DaoFactory;
import dao.SellerDao;
import entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerdao = DaoFactory.createSellerDao();
		
		Seller seller = sellerdao.findById(Integer.parseInt(JOptionPane.showInputDialog("Qual ID deseja buscar?")));
		System.out.println(seller);

	}

}
